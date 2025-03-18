package br.com.bradesco.alura.turma.tres.enums;

import br.com.bradesco.alura.turma.tres.entities.CardStatus;

public enum CardStatusEnum {

    ACTIVE(1L, "CARD ACTIVE"),
    CANCELLED(2L, "CARD STATUS CANCELLED"),
    BLOCKED(3L, "CARD STATUS BLOCKED");

    private Long id;
    private String description;

    CardStatusEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardStatus entityValue() {
        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(this.id);
        cardStatus.setDescription(this.description);
        return cardStatus;
    }
}
