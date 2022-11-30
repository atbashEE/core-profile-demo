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