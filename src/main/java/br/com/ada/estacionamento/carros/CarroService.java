package br.com.ada.estacionamento.carros;

import br.com.ada.estacionamento.vagas.Vaga;
import br.com.ada.estacionamento.vagas.VagaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    public CarroRepository carroRepository;

    @Autowired
    private VagaRepository vagaRepository;

    public Carro cadastrarCarro(Carro carro){
        if (carroRepository.findById(carro.getPlaca()).isPresent()) {
            throw new RuntimeException("Carro já cadastrado");
        }
        return carroRepository.save(carro);
    }

    public List<Carro> buscarCarros() {
        return carroRepository.findAll();
    }

    public String estacionar(Carro carro){
        Integer numberVaga = vagaRepository.countarVagasLivres();
        if (numberVaga == 0) {
            throw new RuntimeException("Todas as vagas estão ocupadas");
        }
        Vaga vaga = vagaRepository.findById(carro.getVaga().getNumero()).orElseThrow();
        if (vaga.isOcupada()) {
            throw new RuntimeException("Vaga ocupada");
        }
        vaga.setOcupada(true);
        vaga.setCarro(carro);

        vagaRepository.save(vaga);

        return String.format("Carro placa %s estacionado na vaga %d",
            carro.getPlaca(), vaga.getNumero());
    }

}
