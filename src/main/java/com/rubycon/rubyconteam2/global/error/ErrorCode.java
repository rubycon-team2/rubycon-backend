package com.rubycon.rubyconteam2.global.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(400, "COMMON_001", "Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "COMMON_002", "Method Not Allowed"),
    ENTITY_NOT_FOUND(404, "COMMON_003", "Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "COMMON_004", "Interval Server Error"),
    INVALID_TYPE_VALUE(400, "COMMON_005", "Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "COMMON_006", "Access is Denied"),
    METHOD_ARGUMENT_MISMATCHED(400, "COMMON_007", "Request Argument 타입이 일치하지 않습니다."),
    UNAUTHORIZED(401, "COMMON_008", "인증되지 않은 사용자입니다."),

    // JWT
    TOKEN_SIGNATURE_INVALID(401, "J001", "유효하지 않은 토큰입니다."),
    TOKEN_MALFORMED(401, "J002", "손상된 토큰입니다."),
    TOKEN_EXPIRED(401, "J003", "만료된 토큰입니다."),
    TOKEN_UNSUPPORTED(401, "J004", "예상되는 형식과 일치하지 않는 토큰입니다."),
    TOKEN_ILLEGAL_ARGUMENT(401, "J005", "토큰이 'null' 또는 빈 문자열입니다."),

    // SMS
    SMS_CODE_EXPIRED(401, "S001", "만료된 인증 코드입니다."),
    SMS_NOT_MATCHING_CODE(401, "S002", "인증 코드가 일치하지 않습니다."),

    // USER
    USER_NOT_FOUND(404, "U001", "사용자를 찾을 수 없습니다."),

    // PARTY
    PARTY_NOT_FOUND(404, "P001", "파티를 찾을 수 없습니다."),
    PARTY_ACCESS_DENIED(403, "P002", "파티장만 파티원 강퇴, 파티를 삭제할 수 있고 파티원만 파티를 탈퇴할 수 있습니다."),
    PARTY_NOT_PROCEEDING(400, "P003", "이미 파티를 탈퇴했거나 종료된 상태입니다."),
    PARTY_OVER_MAX_COUNT(400, "P004", "파티 최대 인원을 초과해서 참여할 수 없습니다."),
    PARTY_ALREADY_LEAVE(403, "P005", "이미 탈퇴한 파티입니다."),
    PARTY_ALREADY_JOIN(403, "P006", "이미 동일한 서비스의 파티에 참여 중입니다. 같은 서비스를 중복해서 참여할 수 없습니다."),

    // PARTY_JOIN
    PARTY_JOIN_NOT_FOUND(404, "PJ001", "해당 파티에 참여 중이지 않습니다."),
    PARTY_JOIN_DUPLICATED(400, "PJ002", "이미 해당 파티에 참여 중입니다."),

    // REVIEW
    REVIEW_DUPLICATED(400, "R001", "이미 리뷰를 한 사용자입니다."),
    IS_NOT_REVIEWABLE(403, "R002", "추가 모집 상태 or 모집 완료 상태에만 리뷰할 수 있습니다."),

    // EX) Member
    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
    LOGIN_INPUT_INVALID(400, "M002", "Login input is invalid"),

    // EX) Coupon
    COUPON_ALREADY_USE(400, "CO001", "Coupon was already used"),
    COUPON_EXPIRE(400, "CO002", "Coupon was already expired")
    ;

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
