package org.generation.brazil.gfood.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {

    @Id     //para falar que o id é a pk da tabela (olhar embaixo o q se refere)
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //generated_value fala que é auto_incremento, se não passar nada no parâmetro, ele passa o default; a estratégia de auto_incremento é o que está no parâmetro; strategy é qual estratégia de auto_incremento que o banco tem - depende de como meu banco reconhece isso. Por algum motivo é Identity pq é como o banco entende.
    private Long id;        //Pode ser Long ou Integer, dá na mesma.      // "generationType.Indetity" aqui = "auto_increment" no MySQL

    @NotNull        //significa que o campo é obrigatório
    private String nome;

    private String descricao;       //como eu não coloquei notnull, significa que não é obrigatório eu colocar a descrição


    //Gerar getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
