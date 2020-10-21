package com.rubycon.rubyconteam2.domain.party.dto.response;

import com.rubycon.rubyconteam2.domain.party.domain.Party;
import com.rubycon.rubyconteam2.domain.party.domain.PartyJoin;
import com.rubycon.rubyconteam2.domain.party.exception.PartyNotFoundException;
import com.rubycon.rubyconteam2.domain.user.dto.response.ProfileWithRoleResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PartyDetailsResponse {

    private PartyResponse party;
    private List<ProfileWithRoleResponse> users = new ArrayList<>();

    public PartyDetailsResponse(List<PartyJoin> partyJoins) {
        Party party = partyJoins.stream()
                .findFirst()
                .map(PartyJoin::getParty)
                .orElseGet(Party::new);

        this.party = new PartyResponse(party);

        partyJoins.forEach(partyJoin -> this.users.add(new ProfileWithRoleResponse(partyJoin)));
    }
}