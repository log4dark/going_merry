package com.log4dark;

import com.log4dark.type.ErrorCode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello dark!");

        // Data Type
        System.out.printf("\n### Data Type ###\n");
        System.out.printf("SUCCESS=%d, UNDER_CONSTRUCTION=%d\n",
                ErrorCode.SUCCESS.value(),ErrorCode.UNDER_CONSTRUCTION.value());
        //--*/
    }
}