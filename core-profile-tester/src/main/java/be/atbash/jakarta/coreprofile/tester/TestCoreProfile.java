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

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

public class TestCoreProfile {

    private final Reflections reflections;
    private final JakartaCoreProfileScanner jakartaCoreProfileScanner;

    /**
     * Construct the tester for non-CDI lite usages.
     * @param packageName  Limits searched classes to this package (and subpackages)
     */
    public TestCoreProfile(String packageName) {
        jakartaCoreProfileScanner = new JakartaCoreProfileScanner(packageName);
        reflections = new Reflections(
                new ConfigurationBuilder()
                        .forPackage(packageName)
                        .setScanners(jakartaCoreProfileScanner));
    }

    public Set<String> violations() {
        return reflections.get(jakartaCoreProfileScanner);
    }

    public Set<String> usagesOf(Class<?> aClass) {
        return reflections.get(jakartaCoreProfileScanner.of(aClass.getName()));
    }

}
