package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IDriveStoreDao;
import edu.moduloalumno.entity.DriveStore;
import edu.moduloalumno.service.IDriveStoreService;

@Service
public class DriveStoreServiceImpl implements IDriveStoreService{

	@Autowired
	private IDriveStoreDao driveStoreDao; 
	
	@Override
	public DriveStore driveStoreName(String codigo) {
		
		return driveStoreDao.driveStoreName(codigo);
	}

}
