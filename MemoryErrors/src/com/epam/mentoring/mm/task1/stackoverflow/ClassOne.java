package com.epam.mentoring.mm.task1.stackoverflow;

public class ClassOne {

    private int oneValue;
    private ClassTwo clsTwoInstance = null;

    public ClassOne() {
        oneValue = 0;
        clsTwoInstance = new ClassTwo();
    }

    public ClassOne(int oneValue, ClassTwo clsTwoInstance) {
        this.oneValue = oneValue;
        this.clsTwoInstance = clsTwoInstance;
    }
}
