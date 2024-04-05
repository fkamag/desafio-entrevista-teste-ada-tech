package br.com.ada.estacionamento.vagas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {

  @Query("select count(v) from Vaga v where v.ocupada = false")
  Integer countarVagasLivres();

}
