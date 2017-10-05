package br.com.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Controller e API bscar do Service (ou BO Business Object)
 * BO busca informações do Respository  (ou DAO)
 * DAO busca do BD
 * 
 * */
@SpringBootApplication
@Controller
public class CursoJavaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoJavaWebApplication.class, args);
	}
	
	@GetMapping
	String index(){
		return "index";
	}
}
