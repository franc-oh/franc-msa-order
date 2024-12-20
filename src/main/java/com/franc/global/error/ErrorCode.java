package com.franc.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    REQUEST_ARGUMENT_NOT_VALID(10001, HttpStatus.BAD_REQUEST, "잘못된 요청 양식입니다."),
    ORDER_FAIL_ARGUMENT_NOT_VALID(10002, HttpStatus.BAD_REQUEST, "주문에 필요한 정보가 없어 주문에 실패했습니다."),
    ORDER_NOT_FOUND(10003, HttpStatus.BAD_REQUEST, "주문을 찾을 수 없습니다."),
    // 404 Not Found
    NOT_FOUND_END_POINT(40400, HttpStatus.NOT_FOUND, "존재하지 않는 API입니다."),
    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
