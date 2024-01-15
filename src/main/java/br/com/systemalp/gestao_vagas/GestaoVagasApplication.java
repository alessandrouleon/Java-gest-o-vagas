package br.com.systemalp.gestao_vagas;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.systemalp.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.systemalp.gestao_vagas.modules.candidate.repositories.CandidateRepository;


@SpringBootApplication
public class GestaoVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVagasApplication.class, args);
	}

   //Esse codigo cadastra um candidate admin
	@Bean
     CommandLineRunner init(CandidateRepository candidateRepository) {
        return args -> {
            // Verifique se não há já um candidato admin no banco de dados
            if (!candidateRepository.findByUsernameOrEmail("admin", "admin@example.com").isPresent()) {
                CandidateEntity adminCandidate = new CandidateEntity();
                adminCandidate.setName("Admin User");
                adminCandidate.setUsername("admin");
                adminCandidate.setEmail("admin@example.com");
                // Removido o uso do passwordEncoder
                adminCandidate.setPassword("adminpassword");
                adminCandidate.setDescription("Administrator");
                adminCandidate.setCreatedAt(LocalDate.now());
                adminCandidate.setUpdatedAt(LocalDate.now());
                candidateRepository.save(adminCandidate);
            }
        };
    }
}
 