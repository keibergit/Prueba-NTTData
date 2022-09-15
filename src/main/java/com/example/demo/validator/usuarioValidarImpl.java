package com.example.demo.validator;

import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

import com.example.demo.exception.errorCorreo;
import com.example.demo.model.Usuarios;
import java.util.regex.Matcher;

@Component
public class usuarioValidarImpl implements usuarioValidar{

	@Override
	public void validator(Usuarios usuarios) throws errorCorreo {
		
		if(usuarios.getName() == null || usuarios.getName().isEmpty()) {
			this.message("El nombre no puede ser vacio");
		}
		
		if(usuarios.getEmail() == null || usuarios.getEmail().isEmpty()) {
			this.message("El correo no puede ser vacio");
		}else {
			String correo = usuarios.getEmail();
			Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); 
			Matcher mat = pat.matcher(correo);
			
			if(!mat.find()) {
				this.message("Formato de correo no valido");
			}
		}
		
		if(usuarios.getPassword() == null || usuarios.getPassword().isEmpty()) {
			this.message("La contraseña no puede ser vacia");
		}else {
			String contra = usuarios.getPassword();
			Pattern pat = Pattern.compile("^[A-Z]{1,1}([a-z])+([0-9]{2,2})$"); 
			Matcher mat = pat.matcher(contra);
			
			if(!mat.find()) {
				this.message("Formato de contraseña no valido");
			}
		}
		
	}
	
	private void message(String message) throws errorCorreo {
		
		throw new errorCorreo(message);		
	}

}
