package br.com.systemalp.gestao_vagas.modules.candidate.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.systemalp.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.systemalp.gestao_vagas.modules.candidate.services.CreateCandidateService;
import br.com.systemalp.gestao_vagas.modules.candidate.services.ProfileCandidateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

   @Autowired
   private CreateCandidateService createCandidateService;

   @Autowired
   private ProfileCandidateService profileCandidateService;

   @PostMapping("/")
   public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
      try {
         var result = this.createCandidateService.execute(candidateEntity);
         return ResponseEntity.ok().body(result);
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

   @GetMapping("/")
    public ResponseEntity<Object> get(HttpServletRequest request) {
      var idCandidate = request.getAttribute("candidate_id");

      try {
         var result = this.profileCandidateService
          .execute(UUID.fromString(idCandidate.toString()));
   
         return ResponseEntity.ok().body(result);

      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }
   
}
