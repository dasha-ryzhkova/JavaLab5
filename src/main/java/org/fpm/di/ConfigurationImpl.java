package org.fpm.di;

import org.fpm.di.interfaces.Binder;
import org.fpm.di.interfaces.Configuration;

public class ConfigurationImpl implements Configuration {
    @Override
    public void configure(Binder binder) {

        binder.bind(MyClassSingleton.class);
        binder.bind(MyClassPrototype.class);

        binder.bind(UseClassA.class);

        binder.bind(ClassA.class, ClassB.class);
        binder.bind(ClassB.class, new ClassB());

    }
}
