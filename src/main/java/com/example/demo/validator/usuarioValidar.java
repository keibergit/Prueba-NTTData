package com.example.demo.validator;

import org.springframework.stereotype.Service;

import com.example.demo.exception.errorCorreo;
import com.example.demo.model.Usuarios;

/*INTERFACE PARA VALIDAR LOS DATOS RECIBIDOS DEL USUARIO*/

@Service
public interface usuarioValidar {
	
	void validator( Usuarios usuarios) throws errorCorreo;

}
