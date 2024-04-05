package br.com.ada.estacionamento.carros;

import br.com.ada.estacionamento.vagas.Vaga;
import br.com.ada.estacionamento.vagas.VagaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CarroController {

    public final CarroService service;
    @Autowired
    private VagaService vagaService;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @PostMapping("carro")
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro){
        Carro carroBD = service.cadastrarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carro);
    }

    @PostMapping("/vaga")
    public ResponseEntity<String> estacionar(@RequestBody Carro carro){
        String result = service.estacionar(carro);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/carro")
    public List<Carro> buscarCarros() {
        return service.buscarCarros();

    }

    @GetMapping("/vaga")
    public List<Vaga> buscarVagas() {
        return vagaService.getVagas();
    }

}
