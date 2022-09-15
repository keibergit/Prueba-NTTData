package com.example.demo.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuarioRepository;


@Service
@Transactional
public class UsusarioServicesImplement implements UsuarioServices{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuarios crearUsuario(Usuarios usuarios) {
		return usuarioRepository.save(usuarios);	
	}

	@Override
	public List<Usuarios> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public void borrarUsuario(long usuarioId) {
		
		Optional<Usuarios> usuario = this.usuarioRepository.findById(usuarioId);
		
		if(usuario.isPresent()) {
			this.usuarioRepository.delete(usuario.get());
		}
		
	}
	
	

	

}
