package br.com.bradesco.alura.turma.tres.services;

import br.com.bradesco.alura.turma.tres.domain.dto.CardDTO;
import br.com.bradesco.alura.turma.tres.domain.request.CardRequest;
import br.com.bradesco.alura.turma.tres.domain.response.CardResponse;
import br.com.bradesco.alura.turma.tres.entities.Card;
import br.com.bradesco.alura.turma.tres.entities.CardStatus;
import br.com.bradesco.alura.turma.tres.enums.CardStatusEnum;
import br.com.bradesco.alura.turma.tres.mapper.CardMapper;
import br.com.bradesco.alura.turma.tres.mapper.CardStatusMapper;
import br.com.bradesco.alura.turma.tres.repositories.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class CardServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(CardServiceImpl.class);

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private CardStatusMapper cardStatusMapper;


    public CardResponse getListOfCards() {
        CardResponse response = new CardResponse();
        List<CardDTO> cards = cardRepository.findAll()
                .stream()
                .map(cardMapper::toDTO)
                .collect(Collectors.toList());
        if (!cards.isEmpty()) {
            response.setCards(cards);
        }

        return response;
    }

    public void createCard(CardRequest request) {
        if (nonNull(request)) {
            Card card = cardMapper.fromRequest(request);
            card.setStatus(CardStatusEnum.CANCELLED.entityValue());
            try {
                cardRepository.saveAndFlush(card);
            } catch (Exception exception) {
                LOG.error("Error when trying create a resident", exception);
                throw exception;

            }
        }
    }

    public void unlockCard(CardDTO request) {
        updateCardStatus(request, CardStatusEnum.ACTIVE.entityValue());
    }

    public void lockCard(CardDTO request) {
        updateCardStatus(request, CardStatusEnum.CANCELLED.entityValue());
    }

    private CardDTO getCardById(Long id) {
        return cardMapper.toDTO(cardRepository.findById(id)
                .orElse(null));
    }

    private void updateCardStatus(CardDTO request, CardStatus status) {
        CardDTO dto = getCardById(request.getId());
        if (nonNull(dto)) {
            Card entity = cardMapper.toEntity(dto);
            entity.setStatus(status);
            try {
                cardRepository.saveAndFlush(entity);
            } catch (Exception exception) {
                LOG.error("Error when trying update");
            }
        }
    }

}
