package br.com.systemalp.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemalp.gestao_vagas.modules.candidate.entityes.CandidateEntity;
import br.com.systemalp.gestao_vagas.modules.candidate.repositoryes.CandidateRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

   @Autowired
   private CandidateRepository candidateRepository;

   @PostMapping("/")
   public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) {
      if (candidateEntity != null) {
         return this.candidateRepository.save(candidateEntity);
      } else {
         return null;
      }
   }

}
