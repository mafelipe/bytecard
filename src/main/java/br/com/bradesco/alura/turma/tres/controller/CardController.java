package br.com.bradesco.alura.turma.tres.controller;

import br.com.bradesco.alura.turma.tres.domain.dto.CardDTO;
import br.com.bradesco.alura.turma.tres.domain.request.CardRequest;
import br.com.bradesco.alura.turma.tres.domain.response.CardResponse;
import br.com.bradesco.alura.turma.tres.services.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/card")
public class CardController {

    @Autowired
    private CardServiceImpl cardService;

    @PostMapping("/create")
    public void createCard(@RequestBody CardRequest request) {
        cardService.createCard(request);
    }

    @PostMapping("/unlock")
    public void unlockCard(@RequestBody CardDTO request) {
        cardService.unlockCard(request);
    }

    @PostMapping("/lock")
    public void lockCard(@RequestBody CardDTO request) {
        cardService.lockCard(request);
    }

    @GetMapping("/list")
    public CardResponse getListOfCards() {
        return cardService.getListOfCards();
    }

}
