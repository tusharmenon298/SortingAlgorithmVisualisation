/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Tushar
 */
public class Sleep {
    public static void sleepFor(long nanoseconds) {
        long timeElapsed;
        final long startTime = System.nanoTime();
        do {
            timeElapsed = System.nanoTime() - startTime;
        } while(timeElapsed < nanoseconds);
    }
    
    public static long secondsToNano(long time) {
        return time * (long)Math.pow(10, 9);
    }
    
    public static long millisecondsToNano(long time) {
        return time * (long)Math.pow(10, 6); 
    }
    
    public static long microsecondsToNano(long time) {
        return time * (long)Math.pow(10, 3); 
    }
}

