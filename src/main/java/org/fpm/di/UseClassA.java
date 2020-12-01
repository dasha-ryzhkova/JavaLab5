package org.fpm.di;

import javax.inject.Inject;

public class UseClassA {
    private final ClassA dependency;
    @Inject
    public UseClassA(ClassA dependency) {
        this.dependency = dependency;
    }
//    @Inject
//    public UseClassA(ClassA dependency) {
//        this.dependency = dependency;
//    }

    public ClassA getDependency() {
        return dependency;
    }
    
}
