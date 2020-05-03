package edu.moduloalumno.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("recaudaciones-id-tipo")
public class RecaudacionesIdTipoController {
	
	
	@GetMapping("/listar/{codigo}")
	public ResponseEntity<?> listarRecaudacionByCodigo(@PathVariable String codigo){	
		return null;
	}

}
