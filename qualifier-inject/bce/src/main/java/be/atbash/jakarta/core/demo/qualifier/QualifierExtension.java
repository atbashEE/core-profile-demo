/*
 * Copyright 2022 Rudy De Busscher (Atbash)
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
package be.atbash.jakarta.core.demo.qualifier;

import jakarta.enterprise.inject.build.compatible.spi.BuildCompatibleExtension;
import jakarta.enterprise.inject.build.compatible.spi.Enhancement;
import jakarta.enterprise.inject.build.compatible.spi.FieldConfig;
import jakarta.enterprise.inject.literal.InjectLiteral;
import jakarta.enterprise.lang.model.AnnotationInfo;
import jakarta.inject.Qualifier;

public class QualifierExtension implements BuildCompatibleExtension {

    @Enhancement(types = Object.class, withSubtypes = true)
    public void enhanceFieldInjection(FieldConfig fieldConfig) {
        if (fieldConfig.info().annotations()
                .stream()
                .anyMatch(this::isQualifier)) {

            fieldConfig.addAnnotation(new InjectLiteral());
        }
    }

    private boolean isQualifier(AnnotationInfo annotationInfo) {
        return annotationInfo.declaration().hasAnnotation(Qualifier.class);
    }
}
