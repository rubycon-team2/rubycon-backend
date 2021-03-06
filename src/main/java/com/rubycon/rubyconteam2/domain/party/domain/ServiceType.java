package com.rubycon.rubyconteam2.domain.party.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServiceType {
    NETFLIX("넷플릭스", 4),
    WATCHA("왓챠", 4),
    WAVVE("웨이브", 4),
    APPLE_MUSIC("애플 뮤직", 6);

    private final String title;
    private final int maxSharedAccountsCount;

    /**
     * 최대 파티 인원 수를 넘었는지 체크
     */
    public boolean isOverMemberCount(Party party) {
        return party.getMemberCount() >= this.getMaxSharedAccountsCount();
    }

    /**
     * 모집 완료 상태인지 체크
     */
    public boolean isRecruitingCompleted(Party party) {
        return party.getMemberCount() + 1 == this.getMaxSharedAccountsCount();
    }
}
