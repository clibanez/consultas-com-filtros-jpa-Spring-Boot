# Exemplo de Consultas com Filtro em Spring Boot
Este projeto de exemplo demonstra como implementar consultas com filtro usando o Spring Boot e o JPA.

# Configuração do Banco de Dados


# Implementação das Consultas
No pacote com.hortifuit.consultas.jpa.repositories, você encontrará a interface ProdutoRepository que estende JpaRepository. Essa interface possui métodos de consulta que você pode utilizar para filtrar os produtos. Abaixo estão os exemplos de consultas disponíveis:

- List<Produto> findByNome(String nome): Retorna uma lista de produtos filtrados pelo nome.
- List<Produto> findByCategoriaNome(String nome): Retorna uma lista de produtos filtrados pelo nome da categoria.
- List<Produto> findByCategoria_Nome(String nome): Também podemos usar esse padrão de nome do método. Mesmo exemplo do método acima.
- @Query("SELECT p FROM Produto p WHERE p.nome = :nome") List<Produto> findByUsandoJPQL(String nome): Utiliza uma consulta JPQL para filtrar os produtos pelo nome.
- @Query(value = "SELECT p.* FROM produtos p JOIN categorias c ON p.categoria_id = c.id WHERE c.nome = :nome", nativeQuery = true) List<Produto> findByCategoriaNomeSQL(String nome): Utiliza uma consulta em SQL para filtrar os produtos pelo nome da categoria.
  
# Utilização das Consultas
No pacote com.hortifuit.consultas.jpa.resource, você encontrará a classe ProdutoResource que define os endpoints da API para realizar as consultas de produtos.

A seguir, estão os endpoints disponíveis para realizar as consultas:

- GET /produtos: Retorna a lista de todos os produtos cadastrados.
- GET /produtos/{nome}: Retorna a lista de produtos filtrados pelo nome.
- GET /produtos/categoria/{nome}: Retorna a lista de produtos filtrados pelo nome da categoria.
- GET /produtos/JPQL/{nome}: Retorna a lista de produtos utilizando uma consulta JPQL.
- GET /produtos/categoriaSQL/{nome}: Retorna a lista de produtos utilizando uma consulta em SQL.
- Certifique-se de substituir {nome} nos endpoints acima pelo nome desejado para a consulta.
