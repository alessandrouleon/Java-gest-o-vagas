package br.com.systemalp.gestao_vagas.modules.candidate.repositoryes;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.systemalp.gestao_vagas.modules.candidate.entityes.CandidateEntity;


public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

    
} 