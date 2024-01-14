package br.com.systemalp.gestao_vagas.exceptions;

import br.com.systemalp.gestao_vagas.utils.helper.CandidateValidationMessages;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super(CandidateValidationMessages.USER_EXISTS);
    }
}
