package br.com.bradesco.alura.turma.tres.domain.dto;

import br.com.bradesco.alura.turma.tres.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
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

    @JsonSerialize(using = LimitSerializer.class)
    @Limit
    private BigDecimal limit;

    private ClientDTO client;

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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
