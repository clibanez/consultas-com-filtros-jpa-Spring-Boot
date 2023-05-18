package com.hortifuit.consultas.jpa.resource;

import com.hortifuit.consultas.jpa.model.Produto;
import com.hortifuit.consultas.jpa.model.dto.ProdutoDTO;
import com.hortifuit.consultas.jpa.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    //Ex01: usando a interface do JPA
    @GetMapping
    public List<ProdutoDTO> listaDeProduto(){
        List<Produto> list = produtoRepository.findAll();
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    //Ex02: usando o padrão de nomenclatura do JPA, filtrando pelo atributo da entidade
    @GetMapping("/{nome}")
    public List<ProdutoDTO> listaDeProdutoPeloNome(@PathVariable String nome){
        List<Produto> list = produtoRepository.findByNome(nome); //Esse é opadrão findByNome()
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    //Ex03:  usando o padrão de nomenclatura do JPA, filtrando pelo atributo do relacionamento da entidade
    @GetMapping("/categoria/{nome}")
    public List<ProdutoDTO> listaDeProdutoPelaCategoriaNome(@PathVariable String nome){
        List<Produto> list = produtoRepository.findByCategoriaNome(nome); //Esse é opadrão findByNome()
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    @GetMapping("/JPQL/{nome}")
    public List<ProdutoDTO> listaDeProdutoUsandoJPQL(@PathVariable String nome){
        List<Produto> list = produtoRepository.findByUsandoJPQL(nome); //Ex04: usando jpql aqui não é obrigado usar o padrão de nomenclatura do JPA,
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    //Ex05: usando o Ex:03 so que em sql usando o padrão de nomenclatura do JPA, filtrando pelo atributo do relacionamento da entidade.
    @GetMapping("/categoriaSQL/{nome}")
    public List<ProdutoDTO> listaDeProdutoPelaCategoriaNomeUsandoSQL(@PathVariable String nome){
        List<Produto> list = produtoRepository.findByCategoriaNome(nome); //Esse é opadrão findByNome()
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }


}
