package br.com.systemalp.gestao_vagas.utils;

public class CandidateValidationMessages {
    public static final String NOT_EMPTY_NAME = "Campo [nome] é obrigatório";

    public static final String NOT_EMPTY_USERNAME = "Campo [usuário] é obrigatório";
    public static final String USERNAME_NO_SPACE = "O campo [usuário] não deve conter espaço";

    public static final String NOT_EMPTY_EMAIL = "Campo [email] é obrigatório";
    public static final String EMAIL_INVALID = "O campo [email] deve conter um email válido";
    
    public static final String NOT_EMPTY_PASSWORD = "Campo [senha] é obrigatório";
    public static final String PASSWORD_LENGTH = "A senha deve ter entre 10 e 100 caracteres";

    public static final String NOT_EMPTY_DESCRIPTION = "Campo [descrição] é obrigatório";
    
    //regex validation message
    public static final String REGEX_VALID_EMPTY_FIELD = "^[a-zA-Z]+( [a-zA-Z]+)*$";
    public static final String REGEX_VALIDATE_USERNAME = "\\S+"; 
}
