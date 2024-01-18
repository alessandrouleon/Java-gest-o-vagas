package br.com.systemalp.gestao_vagas.modules.job.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.systemalp.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.systemalp.gestao_vagas.utils.helper.JobValidationMessages;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "job")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = JobValidationMessages.NOT_EMPTY_DESCRIPTION)
    private String description;

    @NotBlank(message = JobValidationMessages.NOT_EMPTY_BENEFISTS)
    private String benefists;

    @NotBlank(message = JobValidationMessages.NOT_EMPTY_LEVEL)
    private String level;
    
    
    @ManyToOne()
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;
   
    @Column(name = "company_id", nullable = false)
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
 