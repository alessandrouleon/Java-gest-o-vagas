package br.com.systemalp.gestao_vagas.modules.candidate.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import br.com.systemalp.gestao_vagas.utils.CandidateValidationMessages;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = CandidateValidationMessages.REGEX_VALID_EMPTY_FIELD, message = CandidateValidationMessages.NOT_EMPTY_NAME)
    private String name;

    @NotEmpty(message = CandidateValidationMessages.NOT_EMPTY_USERNAME)
    @Pattern(regexp = CandidateValidationMessages.REGEX_VALIDATE_USERNAME, message = CandidateValidationMessages.USERNAME_NO_SPACE)
    private String username;

    @NotBlank(message = CandidateValidationMessages.NOT_EMPTY_EMAIL)
    @Email(message = CandidateValidationMessages.EMAIL_INVALID)
    private String email;
     
    @NotBlank(message = CandidateValidationMessages.NOT_EMPTY_PASSWORD)
    @Length(min = 10, max = 100, message = CandidateValidationMessages.PASSWORD_LENGTH)
    private String password;
    
    @NotBlank(message = CandidateValidationMessages.NOT_EMPTY_DESCRIPTION)
    private String description;
    
    private String curriculum;
    
    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @UpdateTimestamp
    private LocalDate deletedAt;

}
