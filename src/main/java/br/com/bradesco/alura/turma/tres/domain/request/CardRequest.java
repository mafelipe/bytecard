package br.com.bradesco.alura.turma.tres.domain.request;
import br.com.bradesco.alura.turma.tres.domain.dto.CardStatusDTO;

import java.util.Objects;

public class CardRequest {

    public CardRequest(Long id, String number, String cvv, String dueDate, CardStatusDTO cardStatus) {
        this.id = id;
        this.number = number;
        this.cvv = cvv;
        this.dueDate = dueDate;
        this.cardStatus = cardStatus;
    }

    private Long id;

    private String number;

    private String cvv;

    private String dueDate;

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "number='" + number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardRequest that = (CardRequest) o;
        return Objects.equals(number, that.number) && Objects.equals(cvv, that.cvv) && Objects.equals(dueDate, that.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, cvv, dueDate);
    }
}
