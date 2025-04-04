package br.unitins.topicos.ProjetoA1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    
    @Autowired
    private DeveloperService developerService;

    @GetMapping
    public List<Developer> listarDevelopers() {
        
        return developerService.listarDevelopers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> buscarPorId(@PathVariable Long id) {

        Optional<Developer> developer = developerService.buscarPorId(id);

        return developer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Developer salvarDeveloper(@RequestBody DeveloperDTO developerDTO) {

        return developerService.salvarDeveloper(developerDTO);
    }

    @PutMapping("/{id}")
    public Developer atualizarDeveloper(@PathVariable Long id, @RequestBody DeveloperDTO developerDTO) {

        return developerService.atualizarDeveloper(id, developerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDeveloper(@PathVariable Long id) {

        developerService.deletarDeveloper(id);

        return ResponseEntity.noContent().build();
    }
}
