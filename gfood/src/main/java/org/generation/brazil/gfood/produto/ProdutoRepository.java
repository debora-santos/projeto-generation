package org.generation.brazil.gfood.produto;

import org.generation.brazil.gfood.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
