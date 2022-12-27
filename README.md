# Jakarta Core Profile Demos

## core-profile-tester

A tester that reports if you are using classes from CDI-full part of the specification. Since the CDI api artefact contains both and the CDI-full functionality you might encounter issues at runtime. At compile everything passes since the classes are available but they might not be at runtime for a CDI lite implementation.

## qualifier-demo

An example of using `@Enhancement` within CDI Lite.

## synthetic

An example of defining synthetic beans within CDI Lite. (This example could also be using a CDI producer but now can be used during build phase)

## se-run

Run a Jakarta EE Core profile application on Java SE. So no longer the requirement of having a WAR file that is handled by a runtime.

## Demo app with OpenLiberty

Demo application with OpenLiberty (currently with beta version of OpenLiberty)

## Run Jakarta Core profile Application with Atbash runtime

The directory _atbash-run_ contains a project where a Jakarta EE 10 Core profile application is executed in Java SE with the help of Atbash Runtime.  The Runner mode allows to define the Application class (or JAX-RS resource classes), define the configuration and run the application. It is using under the hood the module system of Atbash Runtime.


# Slides

Slides of the Jakarta One Presentation "Exploring the new Jakarta EE Core Profile" can be found in the pdf _core-profile_jakartaOne2022_.