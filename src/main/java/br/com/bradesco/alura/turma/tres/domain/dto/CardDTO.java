package br.com.bradesco.alura.turma.tres.domain.dto;

import br.com.bradesco.alura.turma.tres.annotation.Card;
import br.com.bradesco.alura.turma.tres.annotation.CardSerializer;
import br.com.bradesco.alura.turma.tres.annotation.Cvv;
import br.com.bradesco.alura.turma.tres.annotation.CvvSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

public class CardDTO {

    private Long id;

    @JsonSerialize(using = CardSerializer.class)
    @Card
    private String number;

    @JsonSerialize(using = CvvSerializer.class)
    @Cvv
    private String cvv;

    @JsonProperty("expirationdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    private LocalDate expirationDate;

    private CardStatusDTO status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardStatusDTO getStatus() {
        return status;
    }

    public void setStatus(CardStatusDTO status) {
        this.status = status;
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
}
