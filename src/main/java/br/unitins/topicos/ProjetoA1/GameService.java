package br.unitins.topicos.ProjetoA1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    public List<Game> listarGames() {
        
        return gameRepository.findAll();
    }

    public Optional<Game> buscarPorId(Long id) {

        return gameRepository.findById(id);
    }

    public Game salvarGame(GameDTO gameDTO) {

        Developer developer = developerRepository.findById(gameDTO.idDeveloper()).orElseThrow(() -> new EntityNotFoundException("Developer não encontrado"));

        Game game = new Game(gameDTO, developer);

        System.out.println("Developer na entidade Game: " + game.getDeveloper().getId());

        return gameRepository.save(game);
    }

    public Game atualizarGame(Long id, GameDTO gameDTO) {

        Developer developer = developerRepository.findById(gameDTO.idDeveloper()).orElseThrow(() -> new EntityNotFoundException("Developer não encontrado"));

        Game game = gameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Game não encontrado"));

        game.setDados(gameDTO, developer);

        return gameRepository.save(game);
    }

    public void deletarGame(Long id) {

        gameRepository.deleteById(id);
    }
}
