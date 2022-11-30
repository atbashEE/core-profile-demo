package be.atbash.jakarta.coreprofile.classes;

import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.inject.spi.CDI;

public class BeanManagerField {

    private BeanManager bm;

    public void init() {
        bm = CDI.current().getBeanManager();
    }


    public void doFire(String data) {
        bm.getEvent().fire(data);
    }
}
