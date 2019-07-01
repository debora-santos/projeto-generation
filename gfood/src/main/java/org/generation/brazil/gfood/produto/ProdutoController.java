package org.generation.brazil.gfood.produto;

import org.generation.brazil.gfood.cliente.Cliente;
import org.generation.brazil.gfood.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController     //essa classe faz o papel do controlador. se eu não fizer isso, nao consigo acessar essa classe pela internet
public class ProdutoController {

    @Autowired      //injeta  o repository e posso fazer uso de todos os metodos que tem lá dentro ex:
                    //fala que preciso dessa dependencia para meu controler funcionar. sem autowired o repository é nulo
                    //conceito de injeção de dependÇencia, o spring injeta essa dependência para a gente (repository)
                    // quem está fazendo o new é o spring e para isso ele faz uso das anotações
                    //@xpto - Anotação = código que precisa ser executado
    private ProdutoRepository repository;   //pode ter mais de um repository dentro de um controller        //repository é nome do meu objeto. poderia colocar qualquer nome, NÃO é palavra chave

    @ResponseStatus(HttpStatus.CREATED)     //INSET direto no postman, não no banco. API CREATED retorna o 401
    @PostMapping("/produtos")       //mapeia o endpoint
//    @RequestMapping(value = "/produtos", method = POST)       isso é igual o postmapping, em algum legado pode encontrar.
    public Produto save(@RequestBody Produto produto) {     //save é o nome do método, poderia ser qualquer outra coisa
        return repository.save(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> findAll() {        //public: modificador do método; findAll é o nome do método, poderia ser qq coisa
        return repository.findAll();
    }


    @PutMapping("/produtos/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto)
            throws ResourceNotFoundException {
        return repository.findById(id).map(produtoAtualizado -> {
            produtoAtualizado.setNome(produto.getNome());
            produtoAtualizado.setDescricao(produto.getDescricao());
            return repository.save(produtoAtualizado);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não existe produto cadastrado com o id: " + id));
    }

    @DeleteMapping("/produtos/{id}")        //DELETE direto no postman
    public void delete (@PathVariable Long id) {
        repository.deleteById(id);
    }
}
