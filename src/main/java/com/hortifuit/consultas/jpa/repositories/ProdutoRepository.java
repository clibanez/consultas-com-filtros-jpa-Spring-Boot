package com.hortifuit.consultas.jpa.repositories;

import com.hortifuit.consultas.jpa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);  //Ex02: usando o padrão de nomenclatura do JPA, filtrando pelo atributo da entidade.

    List<Produto> findByCategoriaNome(String nome);  //Ex03:  usando o padrão de nomenclatura do JPA, filtrando pelo atributo do relacionamento da entidade
    List<Produto> findByCategoria_Nome(String nome); //Também podemos usar esse padrão de nome do método.Mesmo exemplo do metodo acima.

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    List<Produto> findByUsandoJPQL(String nome); //Ex04: usando jpql aqui não é obrigado usar o padrão de nomenclatura do JPA,

    @Query(value = "SELECT p.* FROM produtos p JOIN categorias c ON p.categoria_id = c.id WHERE c.nome = :nome", nativeQuery = true)
    List<Produto> findByCategoriaNomeSQL(String nome); //Ex05: usando o Ex:03 so que em SQL usando o padrão de nomenclatura do JPA, filtrando pelo atributo do relacionamento da entidade.
}
