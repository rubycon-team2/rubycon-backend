package com.rubycon.rubyconteam2.domain.party.exception;

import com.rubycon.rubyconteam2.global.error.ErrorCode;
import com.rubycon.rubyconteam2.global.error.exception.BusinessException;

public class PartyOverMaxCountException extends BusinessException {
    public PartyOverMaxCountException() {
        super(ErrorCode.PARTY_OVER_MAX_COUNT);
    }
}