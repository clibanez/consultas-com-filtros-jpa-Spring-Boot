package com.hortifuit.consultas.jpa.model.dto;

import com.hortifuit.consultas.jpa.model.Categoria;
import com.hortifuit.consultas.jpa.model.Produto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProdutoDTO {








    private String nome;
    private int quantidade;

    private Categoria categoria;

    private LocalDateTime dataValidade;

    public ProdutoDTO(Produto produto){
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
        this.categoria = produto.getCategoria();
        this.dataValidade = produto.getDataValidade();
    }

}
