package br.com.bradesco.alura.turma.tres.services;

import br.com.bradesco.alura.turma.tres.domain.dto.CardDTO;
import br.com.bradesco.alura.turma.tres.domain.request.CardRequest;
import br.com.bradesco.alura.turma.tres.domain.response.CardResponse;
import br.com.bradesco.alura.turma.tres.entities.Card;
import br.com.bradesco.alura.turma.tres.entities.CardStatus;
import br.com.bradesco.alura.turma.tres.enums.CardStatusEnum;
import br.com.bradesco.alura.turma.tres.mapper.CardMapper;
import br.com.bradesco.alura.turma.tres.mapper.CardStatusMapper;
import br.com.bradesco.alura.turma.tres.mapper.ClientMapper;
import br.com.bradesco.alura.turma.tres.repositories.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
    private ClientMapper clientMapper;

    @Autowired
    private CardStatusMapper cardStatusMapper;

    public CardResponse getListOfCards(int page, int size) {
        CardResponse response = new CardResponse();
        List<CardDTO> cards = cardRepository.findAll(PageRequest.of(page, size))
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
            card.setNumber(generateRandomNumber(16));
            card.setCvv(generateRandomNumber(3));
            card.setStatus(CardStatusEnum.BLOCKED.entityValue());
            try {
                cardRepository.saveAndFlush(card);
            } catch (Exception exception) {
                LOG.error("Error when trying create a resident", exception);
                throw exception;

            }
        }
    }

    private String generateRandomNumber(int size) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(ThreadLocalRandom.current().nextInt(1, 9));
        }
        return builder.toString();
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
