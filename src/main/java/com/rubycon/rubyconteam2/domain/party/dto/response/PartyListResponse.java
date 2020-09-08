package com.rubycon.rubyconteam2.domain.party.dto.response;

import com.rubycon.rubyconteam2.domain.party.domain.Party;
import com.rubycon.rubyconteam2.domain.party.domain.PartyState;
import com.rubycon.rubyconteam2.domain.party.domain.ServiceType;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PartyListResponse {

    private Long partyId;
    private String title;
    private int maxPartyNumber;
    private int paymentCycle;
    private int pricePerPerson;
    private ServiceType serviceType;
    private PartyState partyState;

    public PartyListResponse(Party party) {
        this.partyId = party.getPartyId();
        this.title = party.getTitle();
        this.maxPartyNumber = party.getMaxPartyNumber();
        this.paymentCycle = party.getPaymentCycle();
        this.pricePerPerson = party.getPricePerPerson();
        this.serviceType = party.getServiceType();
        this.partyState = party.getPartyState();
    }

    @Override
    public String toString() {
        return "PartyListResponse{" +
                "partyId=" + partyId +
                ", title='" + title + '\'' +
                ", maxPartyNumber=" + maxPartyNumber +
                ", paymentCycle=" + paymentCycle +
                ", pricePerPerson=" + pricePerPerson +
                ", serviceType=" + serviceType +
                ", partyState=" + partyState +
                '}';
    }
}