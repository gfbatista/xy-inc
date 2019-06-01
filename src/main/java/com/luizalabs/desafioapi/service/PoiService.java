package com.luizalabs.desafioapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizalabs.desafioapi.model.Poi;
import com.luizalabs.desafioapi.repository.PoiRepository;

@Service
public class PoiService {

	@Autowired
	private PoiRepository poiRepository;

	public List<Poi> list() {
		return poiRepository.findAll();
	}

	public Poi save(Poi poi) {
		return poiRepository.save(poi);
	}

	public List<Poi> listByProximity(long x, long y, long d) {
		List<Poi> itens = list();

		return itens.stream().filter(poi -> calculoCoordenadas(poi, x, y) <= d).collect(Collectors.toList());
	}

	private Double calculoCoordenadas(Poi poi, long x, long  y) {
		return Math.sqrt(Math.pow(poi.getCoordenadaX() - x, 2) + Math.pow(poi.getCoordenadaY() - y, 2));
	}

}
