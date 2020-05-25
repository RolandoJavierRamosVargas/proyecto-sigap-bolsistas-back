package edu.moduloalumno.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.DriveStore;
import edu.moduloalumno.service.IDriveStoreService;

@RequestMapping("/drive-store")
@RestController
public class DriveStoreController {

	@Autowired
	private IDriveStoreService driveStore;
	
	@GetMapping("/listar-nombre/{codigo}")
	public DriveStore listarNombre(@PathVariable String codigo){
		return driveStore.driveStoreName(codigo);
	}
}
