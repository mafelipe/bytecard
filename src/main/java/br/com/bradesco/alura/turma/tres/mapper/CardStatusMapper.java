package br.com.bradesco.alura.turma.tres.mapper;

import br.com.bradesco.alura.turma.tres.domain.dto.CardStatusDTO;
import br.com.bradesco.alura.turma.tres.entities.CardStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardStatusMapper {

    CardStatusDTO toDTO(CardStatus cardStatus);

    CardStatus toEntity(CardStatusDTO cardStatusDTO);

}
