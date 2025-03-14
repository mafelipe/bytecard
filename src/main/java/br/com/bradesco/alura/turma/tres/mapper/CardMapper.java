package br.com.bradesco.alura.turma.tres.mapper;

import br.com.bradesco.alura.turma.tres.domain.dto.CardDTO;
import br.com.bradesco.alura.turma.tres.domain.request.CardRequest;
import br.com.bradesco.alura.turma.tres.entities.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDTO toDTO(Card card);

    Card toEntity(CardDTO cardDTO);

    Card fromRequest(CardRequest request);
}
