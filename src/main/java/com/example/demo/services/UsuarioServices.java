package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Usuarios;

public interface UsuarioServices {
	
	Usuarios crearUsuario( Usuarios usuarios);
	
	List<Usuarios> getUsuarios();
	
	void borrarUsuario(long id);
	
	

}
