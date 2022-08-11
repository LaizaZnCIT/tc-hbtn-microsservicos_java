package com.MegaSenaAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {
	
	@GetMapping("/simpleMessageWelcome")
	   public String mensagemBoasVindas() {
	        return "Bem-vindo a MegaSena!";
	   }


	   @GetMapping("/getNumbers")
	   public List<Integer> numerosMegaSena() {
	        Random random = new Random();
	        List<Integer> numerosGerados = new ArrayList<>();
	        
	        for(int i = 0; i < 14; i++) {
	        	numerosGerados.add(random.nextInt(100));
	        }
	        //Obs: Retornar os números gerados em ordem crescente. 
	        Collections.sort(numerosGerados);
	        return numerosGerados;
	   }
}
