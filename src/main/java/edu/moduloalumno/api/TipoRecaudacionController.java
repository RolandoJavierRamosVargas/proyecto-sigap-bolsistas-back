package edu.moduloalumno.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.TiposRecaudacion;
import edu.moduloalumno.service.ITiposRecaudacionService;

@RestController
@RequestMapping("/tiposRecaudacion")
public class TipoRecaudacionController {

	@Autowired
	private ITiposRecaudacionService tipoRecaudacion;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Map<String,Object> map = new HashMap<>();
		
		List<TiposRecaudacion> recaudaciones=null;
		try {
			recaudaciones=tipoRecaudacion.listar();
		} catch (Exception e) {
			map.put("error", "ocurrio un error con la query");
			map.put("mensaje", "Revise por favor el back");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		map.put("mensaje", "Consulta exitosa");
		map.put("tipoRecaudaciones", recaudaciones);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		
	}
	
}
