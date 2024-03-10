package com.bezkoder.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.postgresql.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	List<Persona> findByApellido(String apellido);
	
	List<Persona> findByEstadoCivil(String estadoCivil);
	
	List<Persona> findByEstadoCivilAndEstadoLaboral(String estadoCivil, String estadoLaboral);
	
	List<Persona> findByEdadLessThanEqual(Integer age); 
	
	List<Persona> findByNombreStartingWith(String letter);
	
	List<Persona> findByApellidoEndingWith(String letter);
	
	List<Persona> findDistinctByNombreAndApellido(String nombre, String apellido); 
	
    @Query("SELECT p.estadoCivil, p.genero, COUNT(p) " +
            "FROM Persona p " +
            "GROUP BY p.estadoCivil, p.genero " +
            "ORDER BY p.estadoCivil, p.genero")
     List<Object> countByEstadoCivilAndGenero();
    
    @Query("SELECT p.estadoCivil, AVG(p.edad) " +
            "FROM Persona p " +
            "WHERE p.estadoLaboral = 'desempleado' " +
            "GROUP BY p.estadoCivil")
     List<Object[]> findAvgAgeOfUnemployedGroupedByEstadoCivil();
     
     @Query("SELECT p FROM Persona p ORDER BY p.edad DESC")
     List<Persona> findAllOrderedByAgeDesc();
     
     @Query("SELECT p.nombre, p.apellido FROM Persona p WHERE p.edad > :edad")
     List<Object[]> findNombreYApellidoByEdadGreaterThan(@Param("edad") int edad);
     
     @Query("SELECT p.estadoCivil, COUNT(p) AS cantidad_personas FROM Persona p GROUP BY p.estadoCivil ORDER BY cantidad_personas DESC")
     List<Object[]> countPersonasGroupedByEstadoCivilOrderedByCountDesc();
}
