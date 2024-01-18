package br.com.systemalp.gestao_vagas.modules.job.dto;

import lombok.Data;

@Data
public class CreateJobDTO {
    private String description;
    private String benefists;
    private String level;
}
