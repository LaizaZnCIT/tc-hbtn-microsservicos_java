package com.example.jpah2demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;
  
  @GetMapping("/welcome")
  public String mensagemBoasVindas() {
     return "Bem-vindo ao Song API!";
  }

  @PostMapping("/addClient")
  public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
    //clienteRepository.save(cliente);
    return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.CREATED);
  }

  @GetMapping("/findAllClients")
  public ResponseEntity<List<Cliente>> findAllClients() {
    //clienteRepository.findAll();
    return new ResponseEntity<List<Cliente>>(clienteRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/findClientById/{id}")
  public ResponseEntity<Optional<Cliente>> findClientById(@PathVariable("id") Long idClient) {
	  //clienteRepository.findById(idClient);
	  return new ResponseEntity<Optional<Cliente>>(clienteRepository.findById(idClient), HttpStatus.OK);
  }

  @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
	  clienteRepository.deleteById(idClient);
    }

  @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
   		clienteRepository.save(cliente);
    }
}
