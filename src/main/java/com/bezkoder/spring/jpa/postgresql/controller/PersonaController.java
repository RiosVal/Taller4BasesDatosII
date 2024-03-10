package com.bezkoder.spring.jpa.postgresql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.spring.jpa.postgresql.model.Persona;
import com.bezkoder.spring.jpa.postgresql.repository.PersonaRepository;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PersonaController {

	@Autowired
	PersonaRepository personaRepository;
	
	@GetMapping("/personas")
	public ResponseEntity<List<Persona>> getAllPersonas(@RequestParam(required=false) String nombre){
		List<Persona> personas = new ArrayList<Persona>();
		
		personaRepository.findAll().forEach(personas::add);
		
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@GetMapping("/buscarEstadoCivil/{estadoCivil}")
	public ResponseEntity<List<Persona>> getByEstadoCivil(@PathVariable("estadoCivil") String estadoCivil){
		List<Persona> personas = new ArrayList<Persona>();
		
		personaRepository.findByEstadoCivil(estadoCivil).forEach(personas::add);
		
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@GetMapping("/buscarApellido/{apellido}")
	public ResponseEntity<List<Persona>> getByApellido(@PathVariable("apellido") String apellido){
		List<Persona> personas = new ArrayList<Persona>();
		
		personaRepository.findByApellido(apellido).forEach(personas::add);
		
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@GetMapping("/buscarEdadMenorQue/{edad}")
	public ResponseEntity<List<Persona>> getByAgeLessThan(@PathVariable("edad") Integer edad){
		List<Persona> personas = new ArrayList<Persona>();
		
		personaRepository.findByEdadLessThanEqual(edad).forEach(personas::add);
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPrimeraLetraNombre/{letra}")
	public ResponseEntity<List<Persona>> getByNameStartingWith(@PathVariable("letra") String letra){
		List<Persona> personas = new ArrayList<Persona>();
		
		personaRepository.findByNombreStartingWith(letra).forEach(personas::add);
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@GetMapping("/buscarUltimaLetraApellido/{letra}")
	public ResponseEntity<List<Persona>> getByLastNameEndingWith(@PathVariable("letra") String letra){
		List<Persona> personas = new ArrayList<Persona>();
		
		personaRepository.findByApellidoEndingWith(letra).forEach(personas::add);
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
    @GetMapping("/cantidadPorEstadoCivilYGenero")
    public ResponseEntity<List<Object>> getCantidadPorEstadoCivilYGenero() {
        List<Object> resultado = personaRepository.countByEstadoCivilAndGenero();
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
    
    @GetMapping("/edadPromedioDesempleadosPorEstadoCivil")
    public ResponseEntity<List<Object[]>> getEdadPromedioDesempleadosPorEstadoCivil() {
        List<Object[]> resultado = personaRepository.findAvgAgeOfUnemployedGroupedByEstadoCivil();
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
	
	@PostMapping("/buscarEstadoCivilLaboral")
	public ResponseEntity<List<Persona>> getByEstadoCivilLaboral(@RequestBody Persona persona){
		List<Persona> personas = new ArrayList<Persona>();
		
		personaRepository.findByEstadoCivilAndEstadoLaboral(persona.getEstadoCivil(), persona.getEstadoLaboral())
			.forEach(personas::add);
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@PostMapping("/buscarDistinctNombreApellido")
	public ResponseEntity<List<Persona>> getDistinctNombreApellido(@RequestBody Persona persona){
		List<Persona> personas = new ArrayList<Persona>();
		
		personaRepository.findDistinctByNombreAndApellido(persona.getNombre(), persona.getApellido()).forEach(personas::add);
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	
}
