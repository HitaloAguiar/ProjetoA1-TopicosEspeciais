package br.unitins.topicos.ProjetoA1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    
}
