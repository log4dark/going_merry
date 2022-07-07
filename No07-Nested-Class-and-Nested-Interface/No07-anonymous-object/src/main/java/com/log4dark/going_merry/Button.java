package com.log4dark.going_merry;

public class Button {
    private OnClickListener onClickListener;

    // Setter... 객체 주입
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void touch() {
        onClickListener.onClick();
    }

    // 중첩 인터페이스
    public interface OnClickListener {
        void onClick();
    }
}
