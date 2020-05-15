package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.ProgramaPresupuesto;

public interface IProgramaPresupuestoDao {

	 public List<ProgramaPresupuesto> listarPrograma(String codigo);
}
