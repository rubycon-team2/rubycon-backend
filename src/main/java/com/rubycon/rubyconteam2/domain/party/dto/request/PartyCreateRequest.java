package com.rubycon.rubyconteam2.domain.party.dto.request;

import com.rubycon.rubyconteam2.domain.party.domain.*;
import com.rubycon.rubyconteam2.global.common.anotation.ValueOfEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PartyCreateRequest {

    @NotEmpty(message = "파티 제목을 입력해주세요.")
    @Size(min=10, message="파티 제목은 10글자 이상 입력해야 합니다.")
    @ApiModelProperty(value = "파티 제목", required = true, example = "넷플릭스 파티 모집")
    private String title;

    @NotNull(message= "파티장 금액을 입력해주세요.")
    @Min(0)
    @ApiModelProperty(value = "파티장 금액", required = true, example = "3600")
    private Integer leaderPrice;

    @NotNull(message= "파티원 금액을 입력해주세요.")
    @Min(0)
    @ApiModelProperty(value = "파티원 금액", required = true, example = "3400")
    private Integer memberPrice;

    @NotEmpty(message= "카카오톡 오픈 채팅방 링크를 입력해주세요.")
    @Pattern(regexp="^https://open.kakao.com/o/.+$")
    @ApiModelProperty(value = "카카오톡 오픈 채팅방", required = true, example = "Ex) 카카오 오픈 채팅방 링크")
    private String kakaoOpenChatUrl;

    @NotEmpty(message = "결제 주기를 입력해주세요 \nMONTH_1 | MONTH_2 | MONTH_6 | YEAR_1")
    @ValueOfEnum(enumClass = PaymentCycle.class)
    @ApiModelProperty(value = "결제 주기", required = true, example = "MONTH_1 | MONTH_2 | MONTH_6 | YEAR_1")
    private String paymentCycle;

    @NotEmpty(message = "서비스 기간을 입력해주세요 \nMONTH_1 | MONTH_2 | MONTH_6 | YEAR_1")
    @ValueOfEnum(enumClass = PartyPeriod.class)
    @ApiModelProperty(value = "서비스 기간", required = true, example = "MONTH_1 | MONTH_2 | MONTH_6 | YEAR_1")
    private String partyPeriod;

    @NotEmpty(message = "서비스 타입을 입력해주세요 \nNETFLIX | WATCHA | WAAVE | APPLE_MUSIC")
    @ValueOfEnum(enumClass = ServiceType.class)
    @ApiModelProperty(value = "서비스 타입", required = true, example = "NETFLIX | WATCHA | WAAVE | APPLE_MUSIC")
    private String serviceType;

    public Party toEntity() {
        return Party.builder()
                .title(title)
                .leaderPrice(leaderPrice)
                .memberPrice(memberPrice)
                .kakaoOpenChatUrl(kakaoOpenChatUrl)
                .paymentCycle(PaymentCycle.valueOf(paymentCycle))
                .partyPeriod(PartyPeriod.valueOf(partyPeriod))
                .serviceType(ServiceType.valueOf(serviceType))
                .memberCount(1)
                .partyState(PartyState.RECRUITING)
                .build();
    }
}
