package com.luizalabs.desafioapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luizalabs.desafioapi.model.Poi;
import com.luizalabs.desafioapi.service.PoiService;

@RestController
@RequestMapping("/poi")
public class PoiController {

	@Autowired
	private PoiService poiService;

	@GetMapping
	public List<Poi> list() {
		return poiService.list();
	}

	@PostMapping
	public ResponseEntity<Poi> create(@Valid @RequestBody Poi poi) {
		Poi poiSalvo = poiService.create(poi);

		return ResponseEntity.status(HttpStatus.CREATED).body(poiSalvo);
	}

	@GetMapping("/proximidade")
	public List<Poi> listByProximity(@RequestParam(value = "x", required = true) Long x,
			@RequestParam(value = "y", required = true) Long y, @RequestParam(value = "d", required = true) Long d) {
		return poiService.listByProximity(x, y, d);
	}

}
