package com.log4dark.going_merry;

public class MyApp {
    public static void main(String[] args) {
        System.out.printf("Hello Dark...\n");

        System.out.println("### CreateThread ###############################");

        // Drum - Thread 클래스로 부터 직접 생성 (Runnable 인터페이스 구현)
        Thread drum = new Thread(new Drum());
        drum.start();

        // Guitar - Thread 하위 클래스로 부터 생성
        Thread guitar = new Guitar();
        guitar.start();
        System.out.printf("guitar thread name: %s\n", guitar.getName());

        // Base - Runnable 인터페이스를 익명 구현 객체 -> 람다식으로 표현
        Thread base = new Thread(() -> {

            Thread thread = Thread.currentThread();
            System.out.printf("base thread name: %s\n", thread.getName());

            for (int i=0; i< 5; i++) {
                System.out.println("둥~~ 둥~~");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        base.start();

        // Song...
        for (int i=0; i<5; i++) {
            System.out.println("살다가~~~ 살다가~~~");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
