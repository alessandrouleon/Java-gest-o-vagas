package br.com.systemalp.gestao_vagas.modules.job.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemalp.gestao_vagas.modules.job.dto.CreateJobDTO;
import br.com.systemalp.gestao_vagas.modules.job.entities.JobEntity;
import br.com.systemalp.gestao_vagas.modules.job.services.CreateJobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company/job")
public class JobController {

  @Autowired
  private CreateJobService createJobService;

  @PostMapping("/")
  @PreAuthorize("hasRole('COMPANY')")
  public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
    try {
      var companyId = request.getAttribute("company_id");
      var jobEntity = JobEntity.builder()
          .benefists(createJobDTO.getBenefists())
          .companyId(UUID.fromString(companyId.toString()))
          .description(createJobDTO.getDescription())
          .level(createJobDTO.getLevel())
          .build();

      var result = this.createJobService.execute(jobEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
