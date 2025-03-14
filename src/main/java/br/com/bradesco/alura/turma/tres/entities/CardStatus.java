package br.com.bradesco.alura.turma.tres.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CARD_STATUS")
public class CardStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CARD_STATUS_UID")
    private Long id;

    @Column(name = "CARD_STATUS_DESCR")
    private String description;

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


}
