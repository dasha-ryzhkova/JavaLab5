package org.fpm.di;

import org.fpm.di.example.*;
import org.fpm.di.interfaces.Container;
import org.fpm.di.interfaces.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerImplTest {
    private Container container;

    @Before
    public void setUp() {
        Environment env = new EnvironmentImpl();
        container = env.configure(new ConfigurationImpl());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MyClassSingleton.class), container.getComponent(MyClassSingleton.class));
    }

    @Test(expected = AssertionError.class)
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyClassPrototype.class), container.getComponent(MyClassPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {

//        binder.bind(ClassA.class, ClassB.class);
//        binder.bind(ClassB.class, new ClassB());

        final ClassB bAsSingleton = container.getComponent(ClassB.class);
        assertSame(container.getComponent(ClassB.class), bAsSingleton);
        assertSame(container.getComponent(ClassA.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseClassA hasADependency = container.getComponent(UseClassA.class);

        assertSame(hasADependency.getDependency(), container.getComponent(ClassB.class));
    }
}