package com.log4dark.going_merry;

public class Window {
    Button button1 = new Button();
    Button button2 = new Button();

    // 필드 초기값으로 대입 (중첩 인터페이스)
    Button.OnClickListener onClickListener = new Button.OnClickListener() {
        @Override
        public void onClick() {
            System.out.println("Send email");
        }
    };

    public Window() {
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("Send sms");
            }
        });
    }


}
