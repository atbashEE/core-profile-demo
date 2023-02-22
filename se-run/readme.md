# Run on Java SE

The JAX-RS spec (in version 3.1) has a new feature to standardise the start of an implementation from within standard Java SE. This means that there is no need anymore to have a WAR packaged artifact that is deployed on a runtime or server in order to make your endpoints available for the user.

Since you can also start the CDI container from a `main` method, it becomes now easy to create your own runtime for the Jakarta EE core profile.

This example shows how you can do this.

## Setup

Have a look at the _pom.xml_ file for the required dependencies. We add Jersey integrated with Weld, and the JSON-B and JSON-P support for Jersey to the project.

## Start application

The start of the application is performed by the class `JakartaApplication`. Instead of just providing an instance of the `Application` class, which would be `DemoApplication`, we make use of the `ResourceConfig` of Jersey so that we can have the automated scanning for JAX-RS resource class instead of defining them through the `getClasses()` method in the `Application` class.

## Build executable jar

To build an executable jar, execute 

```
mvn clean package -Pexec  
```

which build a jar which you can use to run your application outside the IDE.