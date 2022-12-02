package be.atbash.jakarta.core.demo.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String defineHelloMessage() {
        return "Hello %s";
    }
}
