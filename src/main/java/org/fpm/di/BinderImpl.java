package org.fpm.di;

import org.fpm.di.interfaces.Binder;

public class BinderImpl implements Binder {
    @Override
    public <T> void bind(Class<T> clazz) {

    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {

    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {

    }
}
