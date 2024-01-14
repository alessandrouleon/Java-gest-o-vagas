package br.com.systemalp.gestao_vagas.modules.job.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.systemalp.gestao_vagas.modules.job.entities.JobEntity;


public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
