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
