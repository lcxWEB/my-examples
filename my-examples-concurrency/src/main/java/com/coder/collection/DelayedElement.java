package com.coder.collection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: lichunxia
 * @create: 2021-04-02 19:18
 */
public class DelayedElement implements Delayed {

    /**
     * The time the task is enabled to execute in nanoTime units
     */
    private long time;

    public DelayedElement(long time) {
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(time - now(), TimeUnit.SECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this) // compare zero ONLY if same object
            return 0;
        if (other instanceof DelayedElement) {
            DelayedElement x = (DelayedElement) other;
            long diff = time - x.time;
            if (diff < 0)
                return -1;
            else
                return 1;
        }
        long d = (getDelay(TimeUnit.NANOSECONDS) -
                other.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    final long now() {
        return System.nanoTime();
    }
}
