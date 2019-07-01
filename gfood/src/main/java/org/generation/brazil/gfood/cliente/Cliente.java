package org.generation.brazil.gfood.cliente;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data       //Anotação do lombok
@Entity
public class Cliente {

    @Id //já diz que é uma pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //para gerar auto_incremento do meu id
    private Long id;

    @NotNull
    private String nome;

    private String endereco;

    // GETS E SETS DELETADOS E EM VEZ DISSO ADICIONADO A NOTATION DO LOMBOK @Data
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(String endereco) {
//        this.endereco = endereco;
//    }
}
