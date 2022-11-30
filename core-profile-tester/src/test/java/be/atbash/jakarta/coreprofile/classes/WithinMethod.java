package be.atbash.jakarta.coreprofile.classes;

import jakarta.enterprise.inject.spi.CDI;

public class WithinMethod {

    public void fireEvent(Pojo pojo) {
        CDI.current().getBeanManager().getEvent().fire(pojo);
    }
}
