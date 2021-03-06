package com.rubycon.rubyconteam2.domain.party_join.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    LEADER("ROLE_LEADER", "파티장"),
    MEMBER("ROLE_MEMBER", "파티원");

    private final String key;
    private final String title;

    public boolean isMember(){
        return this.equals(Role.MEMBER);
    }

    public boolean isLeader(){
        return this.equals(Role.LEADER);
    }
}
