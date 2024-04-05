package br.com.ada.estacionamento.carros;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, String> {
}
