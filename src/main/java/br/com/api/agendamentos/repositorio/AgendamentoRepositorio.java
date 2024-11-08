package br.com.api.agendamentos.repositorio;

import br.com.api.agendamentos.modelo.Agendamento;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface AgendamentoRepositorio extends PagingAndSortingRepository<Agendamento, Long> {

    Iterable<Agendamento> findAll();

    Object save(Agendamento agendamento);

    void deleteById(Long id);
}
