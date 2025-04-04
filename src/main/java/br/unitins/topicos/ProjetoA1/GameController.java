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
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> listarGames() {
        
        return gameService.listarGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> buscarPorId(@PathVariable Long id) {

        Optional<Game> game = gameService.buscarPorId(id);

        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Game salvarGame(@RequestBody GameDTO gameDTO) {

        return gameService.salvarGame(gameDTO);
    }

    @PutMapping("/{id}")
    public Game atualizarGame(@PathVariable Long id, @RequestBody GameDTO gameDTO) {

        return gameService.atualizarGame(id, gameDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGame(@PathVariable Long id) {

        gameService.deletarGame(id);

        return ResponseEntity.noContent().build();
    }
}
