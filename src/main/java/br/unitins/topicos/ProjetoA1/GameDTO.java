package br.unitins.topicos.ProjetoA1;

import java.time.LocalDate;

public record GameDTO(
    String nome,
    String genero,
    Double preco,
    String plataforma,
    Long idDeveloper,
    LocalDate dataLancamento
) {
    
}
