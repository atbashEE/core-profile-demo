/*
 * Copyright 2022 Rudy De Busscher (https://www.atbash.be)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.atbash.jakarta.coreprofile.tester;

import jakarta.decorator.Decorator;
import jakarta.enterprise.context.ConversationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Decorated;
import jakarta.enterprise.inject.Specializes;
import jakarta.enterprise.inject.spi.*;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.ClassFile;
import org.reflections.Store;
import org.reflections.scanners.Scanner;
import org.reflections.util.QueryBuilder;
import org.reflections.util.QueryFunction;

import java.util.*;
import java.util.stream.Collectors;

class JakartaCoreProfileScanner implements Scanner, QueryFunction<Store, String>, QueryBuilder {

    private static final Set<String> nonCoreClasses;

    static {
        nonCoreClasses = new HashSet<>();
        nonCoreClasses.add(SessionScoped.class.getName());
        nonCoreClasses.add(ConversationScoped.class.getName());
        nonCoreClasses.add(BeanManager.class.getName());
        nonCoreClasses.add(Extension.class.getName());
        nonCoreClasses.add(Producer.class.getName());
        nonCoreClasses.add(ProducerFactory.class.getName());
        nonCoreClasses.add(Decorator.class.getName());
        nonCoreClasses.add(Decorated.class.getName());
        nonCoreClasses.add(Specializes.class.getName());
        nonCoreClasses.add(InjectionTargetFactory.class.getName());
        nonCoreClasses.add(InjectionTarget.class.getName());
    }

    private final String packageName;

    public JakartaCoreProfileScanner(String packageName) {

        this.packageName = packageName;
    }

    @Override
    public List<Map.Entry<String, String>> scan(ClassFile classFile) {
        // Only interested in the package (and also exclude this class as it contains links to all classes we are looking for :) )
        if (!classFile.getName().startsWith(packageName) || JakartaCoreProfileScanner.class.getName().equals(classFile.getName())) {
            return Collections.emptyList();
        }
        List<Map.Entry<String, String>> result;

        ClassPool cp = ClassPool.getDefault();
        try {
            Collection<String> classes = cp.get(classFile.getName()).getRefClasses();
            result = classes.stream()
                    .filter(nonCoreClasses::contains)
                    .map(s -> new AbstractMap.SimpleEntry<>(s, classFile.getName()))
                    .collect(Collectors.toList());
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public String index() {
        return Scanner.super.index();
    }

    @Override
    public Set<String> apply(Store store) {

        Map<String, Set<String>> data = store.get(getClass().getSimpleName());
        if (data.isEmpty()) {
            return Collections.emptySet();
        }
        return nonCoreClasses.stream()
                .map(data::get)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());


    }
}
