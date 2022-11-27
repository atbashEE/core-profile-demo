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
import jakarta.enterprise.inject.build.compatible.spi.Synthesis;
import jakarta.enterprise.inject.build.compatible.spi.SyntheticComponents;
import org.slf4j.Logger;

public class LoggerExtension implements BuildCompatibleExtension {

    @Synthesis
    public void defineLoggerBean(SyntheticComponents syntheticComponents) {
        syntheticComponents.addBean(Logger.class)
                .name("LoggerBean")
                .type(Logger.class)
                //.scope(Dependent.class)
                .createWith(LoggerResolverBean.class);
    }

}
