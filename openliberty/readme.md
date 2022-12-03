# Core Profile example with OpenLiberty

Example of Core Profile application with OpenLiberty as it aligns best with the philosophy of Core profile (modular and only Core profile specifications selectable)

---
**NOTE**

Jakarta EE 10 is still in beta and thus not possible yet to create a minimal sized runtime with only the required features.

---

## Setup

Use the Core Profile API dependency within your _pom.xml_ for the development of your application.

You also need the liberty maven plugin to generate the executable jar file for your server (if you go that route)

The _server.xml_ configuration file of OpenLiberty needs the following features. (No specific feature for the Core Profile itself, yet?)

```
    <featureManager>
        <feature>cdi-4.0</feature>
        <feature>restfulWS-3.1</feature>
        <feature>jsonb-3.0</feature>
    </featureManager>
```

## Running app

With the following commands, you can build and run your application.

```
mvn clean package
java -jar target/demo.jar
```
