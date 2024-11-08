package br.com.api.agendamentos.servico;

import br.com.api.agendamentos.modelo.Agendamento;
import br.com.api.agendamentos.modelo.RespostaModelo;
import br.com.api.agendamentos.repositorio.AgendamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoServico {


    @Autowired
    private AgendamentoRepositorio agendamentoRepositorio;
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Agendamento> listarTodos(){
        return agendamentoRepositorio.findAll();
    }

    public Page<Agendamento> listarPaginado(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return agendamentoRepositorio.findAll(pageable);
    }

    public ResponseEntity<?> casdastrarAlterar(Agendamento agendamento, String acao){
        if(agendamento.getDescricao().equals("")){
            respostaModelo.setMensagem("A descrição do agendamento é obrigatório ");
            return new ResponseEntity<>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if(agendamento.getData().equals("")){
            respostaModelo.setMensagem("A data do agendamento é obrigatório ");
            return new ResponseEntity<>(agendamento, HttpStatus.BAD_REQUEST);
        } else if (agendamento.getHora().equals("")) {
            respostaModelo.setMensagem("A hora é obrigatório");
            return new ResponseEntity<>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if(acao.equals("cadastrar") || agendamento.getId() ==null){
                return new ResponseEntity<>(agendamentoRepositorio.save(agendamento), HttpStatus.CREATED);
            }else{
            return new ResponseEntity<>(agendamentoRepositorio.save(agendamento), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id){
        agendamentoRepositorio.deleteById(id);
        respostaModelo.setMensagem("Agendamento deletado com sucesso");
        return new ResponseEntity<>(respostaModelo, HttpStatus.OK);
    }

}
