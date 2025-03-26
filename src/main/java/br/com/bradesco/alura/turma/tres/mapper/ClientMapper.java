package br.com.bradesco.alura.turma.tres.mapper;

import br.com.bradesco.alura.turma.tres.domain.dto.ClientDTO;
import br.com.bradesco.alura.turma.tres.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientDTO clientDTO);

    ClientDTO toDto(Client client);
}
