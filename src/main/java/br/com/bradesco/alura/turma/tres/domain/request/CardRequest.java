package br.com.bradesco.alura.turma.tres.domain.request;
import br.com.bradesco.alura.turma.tres.domain.dto.CardStatusDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CardRequest {

    public CardRequest(Long id, String number, String cvv, LocalDate expirationDate, CardStatusDTO cardStatus) {
        this.id = id;
        this.number = number;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.cardStatus = cardStatus;
    }

    private Long id;

    private String number;

    private String cvv;

    private BigDecimal limit;

    private LocalDate expirationDate;

    private CardStatusDTO cardStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardStatusDTO getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatusDTO cardStatus) {
        this.cardStatus = cardStatus;
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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", limit=" + limit +
                ", expirationDate=" + expirationDate +
                ", cardStatus=" + cardStatus +
                '}';
    }

}
