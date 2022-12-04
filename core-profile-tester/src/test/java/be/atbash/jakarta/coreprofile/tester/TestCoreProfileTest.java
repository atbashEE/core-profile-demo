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

import jakarta.enterprise.context.SessionScoped;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TestCoreProfileTest {

    @Test
    void usages() {
        TestCoreProfile tester = new TestCoreProfile("be.atbash.jakarta.coreprofile.classes");
        Assertions.assertThat(tester.violations()).containsOnly("be.atbash.jakarta.coreprofile.classes.Scope", "be.atbash.jakarta.coreprofile.classes.WithinMethod", "be.atbash.jakarta.coreprofile.classes.BeanManagerField");
    }

    @Test
    void usages_nothingFound() {
        TestCoreProfile tester = new TestCoreProfile("be.atbash.runtime");
        Assertions.assertThat(tester.violations()).isEmpty();
    }

    @Test
    void usagesOf() {
        TestCoreProfile tester = new TestCoreProfile("be.atbash.jakarta.coreprofile.classes");
        Assertions.assertThat(tester.usagesOf(SessionScoped.class)).containsOnly("be.atbash.jakarta.coreprofile.classes.Scope");
    }

}