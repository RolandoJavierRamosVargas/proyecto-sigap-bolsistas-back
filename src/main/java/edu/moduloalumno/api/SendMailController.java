package edu.moduloalumno.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.SendMail;
import edu.moduloalumno.service.IMailService;


@RestController
@RequestMapping("/mail")
public class SendMailController {

    @Autowired
    private IMailService mailService;

    @PostMapping("/sendMail")
    public void sendMail(@RequestBody SendMail mail){
    
    	try {
    		mailService.sendMail(mail);
    	}catch (Exception e) {
			System.out.println(e);
		}
    	
        
    }
}
