# Example of Build Compatible Extension - Enhancement phase

During the Enhancement phase, that allows you to _transform annotations_. In this example, an extension is created to allow you to omit the `@Inject` when you use a _Qualifier_ annotation.

Since a qualifier indicates _which_ beans should be injected when there are multiple candidates, a qualifier always assumes an _InjectionPoint_.

## module _bce_

This defines a `BuildCompatibleExtension` that has a method annotated with `@Enhancement`.

Each field in any CDI bean is processed, and when an annotation is found that is a _Qualifier_ the `@Inject` annotation is added to the metadata.

## module _demo_

Contains an example in Java SE, using the Java SE CDI container, that the `@Inject` annotation is no longer needed with that Extension active.
