package com.coder.doublecheck;

public class SafeLazyInitialization {

    private static Instance instance;

    /**
     * 由于对getInstance()方法做了同步处理，synchronized将导致性能开销。如果getInstance()方
     * 法被多个线程频繁的调用，将会导致程序执行性能的下降
     * @return
     */
    public synchronized static Instance getInstance() {
        if (instance == null)
            instance = new Instance();
        return instance;
    }
}