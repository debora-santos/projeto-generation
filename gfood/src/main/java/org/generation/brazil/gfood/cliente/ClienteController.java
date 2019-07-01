package org.generation.brazil.gfood.cliente;

import org.generation.brazil.gfood.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

////@Controller
//@RestController
//public class ClienteController {
//
//    //@ResponseBody     //Antigamente usava contoller + reponseBody - para atualizar só uma parte da página
//    //@RequestMapping("/index") // notação antiga
//    @GetMapping("/index")
//    public String index() {
//        return "Uma mensagem de teste!";
//    }
//
//    @PostMapping("/post")
//    public String post() {
//        return "Não dá para fazer pelo navegador!";
//    }
//}     // a gente só viu diferença do controller para o restcontroller, teste para conversar com o navegador

@RestController
public class ClienteController {

    @Autowired  //injeta a dependência que preciso, sem ele o repository dá null. Quando preciso usar algum repository dentro do meu controller.
    private ClienteRepository repository;


    @GetMapping("/clientes")
    public List<Cliente> findAll() {
        //"SELECT * FROM cliente"
        return  repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/clientes")
    public Cliente save(@RequestBody Cliente cliente) {     //requestbody faz a conversão do json em objeto

//        System.out.println("Nome: " + cliente.getNome());     //quando eu insiro dado no postman, printa aqui no console
//        System.out.println("Endereço: " + cliente.getEndereco());

        // "INSERT INTO cliente ..."
        return repository.save(cliente);
    }

    @PutMapping("/clientes/{id}") //o nome que chamo o id é o mesmo que o id embaixo
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente)   //2 parâmetros
        throws ResourceNotFoundException {
        // "UPDATE cliente SET ... WHERE ..."
        return repository.findById(id).map(clienteAtualizado -> {
            clienteAtualizado.setNome(cliente.getNome());
            clienteAtualizado.setEndereco(cliente.getEndereco());
            return repository.save(clienteAtualizado);
        }).orElseThrow(() ->
            new ResourceNotFoundException("Não existe cliente cadastrado com o id: " + id));
    }


    @DeleteMapping("/clientes/{id}")
    public void delete (@PathVariable Long id) {   //tudo que era integer a gnt começou a usar Long
        // "DELETE FROM clioente WHERE id = ..."
        repository.deleteById(id);
    }

}
