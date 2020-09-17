package com.rubycon.rubyconteam2.domain.party.service;

import com.rubycon.rubyconteam2.domain.party.domain.Party;
import com.rubycon.rubyconteam2.domain.party.domain.ServiceType;
import com.rubycon.rubyconteam2.domain.party.dto.request.PartyCreateRequest;
import com.rubycon.rubyconteam2.domain.party.dto.request.PartyUpdateRequest;
import com.rubycon.rubyconteam2.domain.party.exception.PartyNotFoundException;
import com.rubycon.rubyconteam2.domain.party.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartyService {

    private final PartyRepository partyRepository;

    /**
     * 서비스 타입에 따른 전체 모집 중 파티 검색
     */
    public List<Party> findAll(ServiceType serviceType) {
        return partyRepository.findByServiceTypeIs(serviceType);
    }

    /**
     * 특정 파티 1개 조회
     */
    public Party findById(Long partyId) {
        return partyRepository.findById(partyId)
                .orElseThrow(PartyNotFoundException::new);
    }

    /**
     * 모집 파티 생성
     */
    public Party save(PartyCreateRequest partyDto){
        Party party = partyDto.toEntity();
        return partyRepository.save(party);
    }

    /**
     * 모집 파티 수정
     */
    public Party update(Long partyId, PartyUpdateRequest partyDto){
        Party party = this.findById(partyId);
        party.updateMyParty(partyDto);

        return partyRepository.save(party);
    }

    /**
     * 모집 파티 삭제
     * TODO : 파티장만 삭제 가능하도록
     */
    public void delete(Long partyId){
        this.findById(partyId);
        partyRepository.deleteById(partyId);
    }
}
