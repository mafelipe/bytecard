package br.com.bradesco.alura.turma.tres.repositories;

import br.com.bradesco.alura.turma.tres.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
