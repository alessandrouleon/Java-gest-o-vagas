package br.com.systemalp.gestao_vagas.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemalp.gestao_vagas.exceptions.UserFoundException;
import br.com.systemalp.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.systemalp.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.companyRepository.save(companyEntity);
    }
}
