package br.com.api.agendamentos.repositorio;

import br.com.api.agendamentos.modelo.Agendamento;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;


public interface AgendamentoRepositorio extends PagingAndSortingRepository<Agendamento, Long> {

    List<Agendamento> findAllByOrderByDataAscHoraAsc();

    Object save(Agendamento agendamento);

    void deleteById(Long id);

    List<Agendamento> findAgendamentoByDescricao(String texto);

    List<Agendamento> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);
}
