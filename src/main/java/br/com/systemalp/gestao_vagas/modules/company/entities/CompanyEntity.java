package br.com.systemalp.gestao_vagas.modules.company.entities;

import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import br.com.systemalp.gestao_vagas.utils.helper.CompanyValidationMessages;
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
@Entity(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = CompanyValidationMessages.REGEX_VALID_EMPTY_FIELD, message = CompanyValidationMessages.NOT_EMPTY_NAME)
    private String name;

    @NotEmpty(message = CompanyValidationMessages.NOT_EMPTY_USERNAME)
    @Pattern(regexp = CompanyValidationMessages.REGEX_VALIDATE_USERNAME, message = CompanyValidationMessages.USERNAME_NO_SPACE)
    private String username;

    @NotBlank(message = CompanyValidationMessages.NOT_EMPTY_DESCRIPTION)
    private String description;

    @NotBlank(message = CompanyValidationMessages.NOT_EMPTY_EMAIL)
    @Email(message = CompanyValidationMessages.EMAIL_INVALID)
    private String email;

    @NotBlank(message = CompanyValidationMessages.NOT_EMPTY_PASSWORD)
    @Length(min = 10, max = 100, message = CompanyValidationMessages.PASSWORD_LENGTH)
    private String password;

    @NotBlank(message = CompanyValidationMessages.NOT_EMPTY_WEBSIT)
    private String websit;

    @CreationTimestamp
    private Instant createAt;

}
