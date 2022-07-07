package com.log4dark.going_merry;

public class Drum implements Runnable {
    public void run() {
        for (int i=0; i< 5; i++) {
            System.out.println("쿵짝 쿵짝");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}