package com.log4dark.going_merry;

public class Guitar extends Thread {
    @Override
    public void run() {
        for (int i=0; i< 5; i++) {
            System.out.println("징찡~ 징찡~");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
