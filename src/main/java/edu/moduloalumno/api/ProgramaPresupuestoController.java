package edu.moduloalumno.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.ProgramaPresupuesto;
import edu.moduloalumno.service.IProgramaPresupuestoService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/programa_presupuesto")
public class ProgramaPresupuestoController {

	@Autowired
	private IProgramaPresupuestoService programaPresupuestoService;
	
	
	@GetMapping("/listar/{codigo}")
	private List<ProgramaPresupuesto> listarProgramaPresupuesto(@PathVariable String codigo){
		return programaPresupuestoService.listarPrograma(codigo);
	}
}
