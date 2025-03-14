package br.com.bradesco.alura.turma.tres.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CARD", uniqueConstraints = { @UniqueConstraint(columnNames = "NUMERO") })
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CARD_UID")
    private Long id;

    @Column(name = "NUMERO")
    private String number;

    @Column(name = "CVV")
    private String cvv;

    @Column(name = "VENCIMENTO")
    private String dueDate;

    @ManyToOne
    @JoinColumn(name = "CARD_STATUS_UID", referencedColumnName = "CARD_STATUS_UID")
    private CardStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

}
