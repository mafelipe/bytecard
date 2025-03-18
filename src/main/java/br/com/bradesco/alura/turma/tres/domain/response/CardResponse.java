package br.com.bradesco.alura.turma.tres.domain.response;

import br.com.bradesco.alura.turma.tres.domain.dto.CardDTO;

import java.util.List;

public class CardResponse {

    private List<CardDTO> cards;

    public List<CardDTO> getCards() {
        return cards;
    }

    public void setCards(List<CardDTO> cards) {
        this.cards = cards;
    }
}
