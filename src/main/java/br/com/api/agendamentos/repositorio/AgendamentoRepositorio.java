package br.com.api.agendamentos.repositorio;

import br.com.api.agendamentos.modelo.Agendamento;
import org.springframework.data.repository.CrudRepository;


public interface AgendamentoRepositorio extends CrudRepository<Agendamento, Long> {

}
