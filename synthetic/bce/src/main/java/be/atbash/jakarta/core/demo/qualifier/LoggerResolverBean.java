package be.atbash.jakarta.core.demo.qualifier;

import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.build.compatible.spi.Parameters;
import jakarta.enterprise.inject.build.compatible.spi.SyntheticBeanCreator;
import jakarta.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerResolverBean implements SyntheticBeanCreator<Logger> {
    @Override
    public Logger create(Instance lookup, Parameters params) {
        InjectionPoint injectionPoint = (InjectionPoint) lookup.select(InjectionPoint.class).get();

        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
        //return LoggerFactory.getLogger("X");
    }
}
