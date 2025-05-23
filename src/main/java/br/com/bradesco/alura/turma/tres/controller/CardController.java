package br.com.bradesco.alura.turma.tres.controller;

import br.com.bradesco.alura.turma.tres.domain.dto.CardDTO;
import br.com.bradesco.alura.turma.tres.domain.request.CardRequest;
import br.com.bradesco.alura.turma.tres.domain.response.CardResponse;
import br.com.bradesco.alura.turma.tres.services.CardServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/card")
public class CardController {

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
    public CardResponse getListOfCards(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return cardService.getListOfCards(page, size);
    }

}
