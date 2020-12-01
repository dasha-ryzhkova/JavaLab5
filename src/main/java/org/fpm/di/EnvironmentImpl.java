package org.fpm.di;

import org.fpm.di.interfaces.Binder;
import org.fpm.di.interfaces.Configuration;
import org.fpm.di.interfaces.Container;
import org.fpm.di.interfaces.Environment;

public class EnvironmentImpl implements Environment {
    @Override
    public Container configure(Configuration configuration) {
        ContainerImpl container = new ContainerImpl(configuration);
        return container;
    }
}
