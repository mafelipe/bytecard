package br.com.bradesco.alura.turma.tres.repositories;

import br.com.bradesco.alura.turma.tres.entities.Card;
import br.com.bradesco.alura.turma.tres.entities.CardStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Page<Card> findCardByStatus(Pageable pageable, CardStatus status);
}
