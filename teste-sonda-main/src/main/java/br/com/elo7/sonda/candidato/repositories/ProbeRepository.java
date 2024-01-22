package br.com.elo7.sonda.candidato.repositories;

import br.com.elo7.sonda.candidato.domains.models.Probe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbeRepository extends CrudRepository<Probe, Long> {
}
