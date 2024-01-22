package br.com.elo7.sonda.candidato.repositories;

import br.com.elo7.sonda.candidato.domains.models.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
}
