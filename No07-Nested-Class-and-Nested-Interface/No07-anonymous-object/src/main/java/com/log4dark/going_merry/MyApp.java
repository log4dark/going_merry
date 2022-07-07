package com.log4dark.going_merry;

public class MyApp {
    public static void main(String[] args) {
        System.out.printf("Hello Dark...\n");

        System.out.println("### 익명 자식 객체 ###################################");
        AnonymousSubObj anonymousSubObj = new AnonymousSubObj();
        anonymousSubObj.dark.wake(); // 익명객체 필드
        anonymousSubObj.method1(); // 익명객체 메소드
        anonymousSubObj.method2(new Person() { // 익명객체 파라미터
            void walk() {
                System.out.println("산책");
            }
            @Override
            void wake() {
                System.out.print("6시에... ");
                walk();
            }
        });

        System.out.println("### 익명 구현 객체 ###################################");
        Window window = new Window();
        window.button1.touch();
        window.button2.touch();
    }
}
