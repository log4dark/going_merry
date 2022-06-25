package com.log4dark.type;

public enum ErrorCode {
    SUCCESS(0), // SUCCESS 객체를 생성, 생성자 구현 후 '0'으로 설정
    ERROR(1),

    UNDER_CONSTRUCTION(9000),

    // api & parameters...
    INVALID_API(80000),
    INVALID_PARAMETER(80001),
    INVALID_AUTH_CODE_FORMAT(80002),

    // tcp
    TCP_FAILED(80010),
    IMAS_CONNECT_FAILED(80011),
    IMAS_CONNECT_OR_READ_TIMEOUT(80012),
    IMAS_SEND_FAILED(80013),
    IMAS_CLOSE_FAILED(80014),
    IMAS_UNDER_CONSTRUCTION(89000);

    private final int errorCode;
    ErrorCode(int errorCode) { this.errorCode = errorCode; }
    public int value() { return errorCode; }
}
