package br.com.ada.estacionamento.vagas;

import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

    @Autowired
    public VagaRepository repository;

    @PostConstruct
    public void criarVagas(){
        for (int i = 0; i < 10; i++){
            repository.save(new Vaga());
        }
    }

    public Vaga getVaga(Integer number) {
        return repository.findById(number).orElseThrow();
    }

    public List<Vaga> getVagas() {
        return repository.findAll();
    }

    public String retirarCarro(Integer id) {
        Vaga vaga = repository.findById(id)
            .orElseThrow();
        vaga.setOcupada(false);

        repository.save(vaga);

        return String.format("Veículo retirado da vaga %d", id);
    }
}
