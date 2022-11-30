# Jakarta EE Core Profile tester

Within the Core profile, CDI lite and CDI full are special cases. There is only 1 specification and 1 API jar although only CDI lite is supported in the Core profile and CDI full in the Web and Full profile.

This means that there is just an indication within JavaDoc and the specification of which classes and methods are not supported by a runtime.  So when you compile against the API, your application might fail at runtime on a Core Profile product.

This _Jakarta EE Core Profile tester_ helps you in detecting this problem during the test phase so that you don't have any surprises at runtime.

## Setup and test

Add the following dependency to your project.

```
        <dependency>
            <groupId>be.atbash.jakarta</groupId>
            <artifactId>core-profile-tester</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>test</scope>
        </dependency>
```

You can write the following test to find out if any of the unsupported classes (within CDI Lite) of the CDI API artifact are used.

```
    void testCompliance() {
        TestCoreProfile tester = new TestCoreProfile("be.atbash");
        Assertions.assertThat(tester.violations()).isEmpty();
    }
```

The string passed to the constructor of the `TestCoreProfile` class is the package that needs to be scanned. It normally indicates the package of your application, but you can also test any 3rd party library by specifying a package from the library.

Sub-packages of the indicated one are also scanned.

The `violations()` method returns the classes where one or more of the classes that aren't supported in CDI lite is used. If empty, as the tests checks, means that your application will run fine on a Jakarta Core Profile runtime.

## Detected classes

This is the list of classes the tester detects and reports as problematic.

- SessionScoped
- ConversationScoped
- BeanManager
- Extension
- Producer
- ProducerFactory
- Decorator
- Decorated
- Specializes
- InjectionTargetFactory
- InjectionTarget
