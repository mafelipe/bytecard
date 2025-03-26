package br.com.bradesco.alura.turma.tres.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CARD", uniqueConstraints = { @UniqueConstraint(columnNames = "NUMERO") })
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CARD_UID")
    private Long id;

    @Column(name = "NUMERO", length = 16)
    @Size(min = 16, max = 16)
    private String number;

    @Column(name = "CVV", length = 3)
    @Size(min = 3, max = 3)
    private String cvv;

    @Column(name = "VENCIMENTO", nullable = false)
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "CARD_STATUS_UID", referencedColumnName = "CARD_STATUS_UID")
    private CardStatus status;

    @Column(name = "CARD_LIMIT")
    private BigDecimal limit;

    @ManyToOne
    @JoinColumn(name = "CLIENT_UID", referencedColumnName = "CLIENT_UID")
    private Client client;

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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
