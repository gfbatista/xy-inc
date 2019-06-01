package com.luizalabs.desafioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luizalabs.desafioapi.model.Poi;

public interface PoiRepository extends JpaRepository<Poi, Long> {
	
}
