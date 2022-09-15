package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.errorCorreo;
import com.example.demo.model.Usuarios;
import com.example.demo.services.UsuarioServices;
import com.example.demo.validator.usuarioValidarImpl;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioServices usuarioServices;
	
	@Autowired
	private usuarioValidarImpl valida;
	
	@PostMapping("/user")
	public ResponseEntity<Usuarios> crearUsario(@RequestBody Usuarios usuarios) throws errorCorreo{
		
	//valida los campos que envia el usuario//
		this.valida.validator(usuarios);
			
		Usuarios userNew = usuarioServices.crearUsuario(usuarios);
		
		return new ResponseEntity<Usuarios>(userNew, HttpStatus.OK);
	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuarios>> getUsuarios(){
		return ResponseEntity.ok().body(usuarioServices.getUsuarios());
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus  borrarUsuario(@PathVariable long id){
		this.usuarioServices.borrarUsuario(id);
		return HttpStatus.OK;
	}
}
