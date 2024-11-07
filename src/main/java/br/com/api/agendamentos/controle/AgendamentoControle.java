package br.com.api.agendamentos.controle;

import br.com.api.agendamentos.modelo.Agendamento;
import br.com.api.agendamentos.modelo.RespostaModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.api.agendamentos.servico.AgendamentoServico;

@RestController
@CrossOrigin(origins = "*")
public class AgendamentoControle {

    @Autowired
    private AgendamentoServico agendamentoServico;


    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Agendamento agendamento){
        return agendamentoServico.casdastrarAlaterar(agendamento, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Agendamento agendamento){
        return agendamentoServico.casdastrarAlaterar(agendamento, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<Agendamento> listar(){
        return agendamentoServico.listar();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id){
        return agendamentoServico.remover(id);
    }

    @GetMapping("/")
    public String rota(){
        return "API de agendamentos funcionando";
    }


}
