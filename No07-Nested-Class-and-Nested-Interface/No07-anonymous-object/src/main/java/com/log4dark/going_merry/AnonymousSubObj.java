package com.log4dark.going_merry;

public class AnonymousSubObj {
    // 필드 초기값
    Person dark = new Person() {
        void work() {
            System.out.println("수영");
        }
        @Override
        void wake() {
            System.out.print("8시에... ");
            work();
        }
    };

    // 메소드의 로컬변수
    public void method1() {
        Person penny = new Person() {
        };
        penny.wake();
    }

    // 메소드의 파라미터
    public void method2(Person person) {
        person.wake();
    }
}
