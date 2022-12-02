/*
 * Copyright 2021 Rudy De Busscher (https://www.atbash.be)
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
package be.atbash.jakarta.core.demo;


import jakarta.ws.rs.SeBootstrap;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.concurrent.CountDownLatch;

public class JakartaApplication {

    public static void main(String[] args) {

        SeBootstrap.Configuration.Builder configBuilder = SeBootstrap.Configuration.builder();
        configBuilder.property(SeBootstrap.Configuration.PROTOCOL, "HTTP")
                .property(SeBootstrap.Configuration.HOST, "localhost")
                .property(SeBootstrap.Configuration.PORT, 8080);


        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages(DemoApplication.class.getPackageName());

        SeBootstrap.start(resourceConfig, configBuilder.build());

        // Not using this way as it expects the resources defined in getClasses()
        //SeBootstrap.start(new DemoApplication(), configBuilder.build());

        keepRunning();


    }

    private static void keepRunning() {
        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
