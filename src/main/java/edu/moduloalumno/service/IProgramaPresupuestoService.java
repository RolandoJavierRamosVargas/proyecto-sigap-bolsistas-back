package edu.moduloalumno.service;

import java.util.List;

import edu.moduloalumno.entity.ProgramaPresupuesto;

public interface IProgramaPresupuestoService {

	 public List<ProgramaPresupuesto> listarPrograma(String codigo);
}
