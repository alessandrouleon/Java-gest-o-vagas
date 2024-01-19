package br.com.systemalp.gestao_vagas.modules.candidate.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.systemalp.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.systemalp.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import lombok.NonNull;

@Service
public class ProfileCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(@NonNull UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .description(candidate.getDescription())
                .build();

        return candidateDTO;
    }

}
