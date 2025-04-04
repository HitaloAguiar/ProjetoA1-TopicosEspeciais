package br.unitins.topicos.ProjetoA1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DeveloperService {
    
    @Autowired
    private DeveloperRepository developerRepository;

    public List<Developer> listarDevelopers() {
        
        return developerRepository.findAll();
    }

    public Optional<Developer> buscarPorId(Long id) {

        return developerRepository.findById(id);
    }

    public Developer salvarDeveloper(DeveloperDTO developerDTO) {

        Developer developer = new Developer(developerDTO);

        return developerRepository.save(developer);
    }

    public Developer atualizarDeveloper(Long id, DeveloperDTO developerDTO) {

        Developer developer = developerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Developer não encontrado"));

        developer.setDados(developerDTO);

        return developerRepository.save(developer);
    }

    public void deletarDeveloper(Long id) {

        developerRepository.deleteById(id);
    }
}
