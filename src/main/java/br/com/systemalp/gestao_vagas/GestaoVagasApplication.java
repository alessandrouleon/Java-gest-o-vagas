package br.com.systemalp.gestao_vagas;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.systemalp.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.systemalp.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@SpringBootApplication
public class GestaoVagasApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoVagasApplication.class, args);
    }

    // Esse codigo cadastra um candidate admin
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner init(CandidateRepository candidateRepository) {

        return args -> {
            // Verifique se não há já um candidato admin no banco de dados
            if (!candidateRepository.findByUsernameOrEmail("admin", "admin@example.com").isPresent()) {
                CandidateEntity adminCandidate = new CandidateEntity();

                var password = this.passwordEncoder.encode("adminpassword");

                adminCandidate.setName("Admin User");
                adminCandidate.setUsername("admin");
                adminCandidate.setEmail("admin@example.com");
                adminCandidate.setPassword(password);
                adminCandidate.setDescription("Administrator");
                adminCandidate.setCreatedAt(LocalDate.now());
                adminCandidate.setUpdatedAt(LocalDate.now());
                candidateRepository.save(adminCandidate);
            }
        };
    }
}
