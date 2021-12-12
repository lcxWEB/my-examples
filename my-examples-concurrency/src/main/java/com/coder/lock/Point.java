package com.coder.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author: lichunxia
 * @create: 2021-03-29 16:50
 */
public class Point {

    private final StampedLock sl = new StampedLock();
    private double x, y;

    public static void main(String[] args) {

    }

    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin() {
        // 首先，通过tryOptimisticRead方法获取乐观读标记
        long stamp = sl.tryOptimisticRead();

        // 然后从主内存中加载点的坐标值 (x,y)
        double currentX = x, currentY = y;

        // 而后通过StampedLock的validate方法校验锁状态，判断坐标点(x,y)从主内存加载到线程工作内存过程中，
        // 主内存的值是否已被其他线程通过move方法修改，如果validate返回值为true，证明(x, y)的值未被修改，
        // 可参与后续计算；否则，需加悲观读锁，再次从主内存加载(x,y)的最新值，然后再进行距离计算
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

}
