# Example of Build Compatible Extension - Synthesis phase

During the Synthesis phase you can define the metadata of Beans that will be created programmatically.

The data that you need to specifiy are a name, type (class for the Bean) and the class that will be creating (the) instance(s).

## module _bce_

This defines a `BuildCompatibleExtension` that has a method annotated with `@Synthesis`.

It defines a CDi bean for injecting a SLF4J logger.

## module _demo_

Contains an example in Java SE, using the Java SE CDI container, for injecting a SLF4J Logger but using the name of the class where it is injected.
