package br.com.ada.estacionamento.vagas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {
}
