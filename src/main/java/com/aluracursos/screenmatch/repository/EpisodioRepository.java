package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {
/*
    SELECT e.* FROM series s JOIN episodios e on s.id = e.serie_id WHERE e.titulo ILIKE %:episodio%
*/
    @Query(value = "SELECT e.* FROM series s JOIN episodios e ON s.id = e.serie_id WHERE e.titulo ILIKE %:episodio%", nativeQuery = true)
    List<Episodio> episodiosPorNombre(String episodio);
    @Query(value = "SELECT e.* FROM series s JOIN episodios e ON s.id = e.serie_id WHERE s.titulo = :titulo ORDER BY e.evaluacion DESC LIMIT 5", nativeQuery = true)
    List<Episodio> top5Episodios(String titulo);
}
