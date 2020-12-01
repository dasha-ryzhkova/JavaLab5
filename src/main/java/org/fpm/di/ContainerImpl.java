package org.fpm.di;

import org.fpm.di.interfaces.Configuration;
import org.fpm.di.interfaces.Container;

import javax.inject.Inject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ContainerImpl implements Container {
    Configuration configuration;

    @Inject
    public ContainerImpl(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        Constructor<?> ctor = null;
        T component = null;

        try {
            ctor = clazz.getConstructor();
            ctor.setAccessible(true);
            component = (T) ctor.newInstance(new Object[]{});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return component;
    }
}

//
//
//
//
//


