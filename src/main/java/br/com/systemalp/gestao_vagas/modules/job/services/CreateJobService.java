package br.com.systemalp.gestao_vagas.modules.job.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemalp.gestao_vagas.modules.job.entities.JobEntity;
import br.com.systemalp.gestao_vagas.modules.job.repositories.JobRepository;

@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        if (jobEntity == null) {
            throw new RuntimeException("Falha ao salvar a entidade JobEntity");
        }
        return this.jobRepository.save(jobEntity);
    }
}
