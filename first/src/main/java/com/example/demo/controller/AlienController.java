package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepository;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
    @Autowired
	AlienRepository rep;
    
	@GetMapping(path="/Alien/{aid}")
	Optional<Alien> searchById(@PathVariable("aid") int aid) {
		
		Optional<Alien> ref = rep.findById(aid);	
		return ref;
	}
	@PostMapping(path="/alien",consumes="application/json")
	Alien add(@RequestBody Alien alien) {
		if(!rep.existsById(alien.getAid())) {
			rep.save(alien);
		}
		
		return alien;
	}
	@DeleteMapping(path="/Alien/{aid}")
	String delete(@PathVariable("aid") int aid) {
		
		rep.deleteById(aid);
		return "done";
	}
	@GetMapping(path="/Aliens",produces={"application/xml","application/json"})
	List<Alien> home(){
		return rep.findAll();
		
	}
	@PutMapping(path="/alien")
	Alien updateOrCreate(@RequestBody Alien alien) {
		
		rep.save(alien);
		return alien;
	}
	
	
	
		
	
	
	
}
