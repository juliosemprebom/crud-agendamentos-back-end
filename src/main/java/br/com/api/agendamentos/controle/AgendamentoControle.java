package br.com.api.agendamentos.controle;

import br.com.api.agendamentos.modelo.Agendamento;
import br.com.api.agendamentos.modelo.RespostaModelo;
import br.com.api.agendamentos.servico.AgendamentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AgendamentoControle {

    @Autowired
    private AgendamentoServico agendamentoServico;


    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Agendamento agendamento){
        return agendamentoServico.casdastrarAlterar(agendamento, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Agendamento agendamento){
        return agendamentoServico.casdastrarAlterar(agendamento, "cadastrar");
    }

    @GetMapping("/listarTodos")
    public Iterable<Agendamento> listarTodos(){
        return agendamentoServico.listarTodos();
    }

    @GetMapping("/listar")
    public Page<Agendamento> listarPaginado(@RequestParam int page, @RequestParam int size) {
        return agendamentoServico.listarPaginado(page, size);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id){
        return agendamentoServico.remover(id);
    }

}
