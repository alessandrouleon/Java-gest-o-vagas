package br.com.systemalp.gestao_vagas.modules.job.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemalp.gestao_vagas.modules.job.entities.JobEntity;
import br.com.systemalp.gestao_vagas.modules.job.services.CreateJobService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobService createJobService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity){
      try {
        var result = this.createJobService.execute(jobEntity);
        return ResponseEntity.ok().body(result);
      } catch (Exception e) {
       return ResponseEntity.badRequest().body(e.getMessage());
      }
    }
}
