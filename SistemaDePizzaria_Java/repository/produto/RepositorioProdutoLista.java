package repository.produto;

import model.pedido.Produto;
import pattern.IdGeneratorStrategy;
import repository.produto.SequencialProdutoIdGeneratorStrategy;

import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioProdutoLista implements RepositorioProduto, Serializable {
  ArrayList<Produto> produtos;
  IdGeneratorStrategy idGenerator;

  public RepositorioProdutoLista() {
    this.produtos = new ArrayList<>();
    idGenerator = new SequencialProdutoIdGeneratorStrategy();

  }

  @Override
  public void inserirProduto(Produto produto) {
    if (produto.getIdProduto() == null) {
      produto.setIdProduto(Long.valueOf(idGenerator.nextId()));
      produtos.add(produto);
    } else {
      try {
        while (buscaProdutoId(produto.getIdProduto()) != null) {
          produto.setIdProduto(Long.valueOf(idGenerator.nextId()));
        }
      } catch (ProdutoNaoCadastradoException e) {
        produtos.add(produto);
        System.out.println("Catch");
      }
    }
  }

  @Override
  public void alterarProduto(Produto produto) throws ProdutoNaoCadastradoException {
    Produto produto1 = buscaProdutoId(produto.getIdProduto());

  }

  @Override
  public void deletarProduto(Produto produto) throws ProdutoNaoCadastradoException {
    produtos.remove(produto);
  }

  // @Override
  public ArrayList<Produto> buscarProdutoCat(String categoria) throws CategoriaNaoExisteException {
    ArrayList<Produto> produtosCat = new ArrayList<>();
    for (Produto produto : produtos) {
      if (produto.getCategoriaProduto().equals(categoria)) {
        produtosCat.add(produto);
      }
    }
    return produtosCat;
  }

  // @Override
  public Produto buscaProdutoId(Long id) throws ProdutoNaoCadastradoException {
    for (Produto produto : produtos) {
      if (produto.getIdProduto().equals(id)) {
        return produto;
      } else {
        throw new ProdutoNaoCadastradoException();
      }
    }
    return null;
  }

  // @Override
  public ArrayList<Produto> getAll() {
    return produtos;
  }
}

/*
 * package repository.produto;
 * 
 * import java.util.List;
 * import java.util.ArrayList;
 * import model.produto.Produto;
 * 
 * public class RepositorioProdutoLista implements RepositorioProduto {
 * List<Produto> produto;
 * 
 * public RepositorioProdutoLista() {
 * this.produto = new ArrayList<Produto>();
 * }
 * 
 * @Override
 * public void inserirProduto(Produto produto) throws ProdutoCadastradoException
 * {
 * try {
 * buscarProduto(produto.getIdProduto());
 * throw new ProdutoCadastradoException();
 * }
 * catch (ProdutoNaoCadastradoException ex) {
 * produto.add(produto);
 * }
 * 
 * @Override
 * public void alterarProduto(Produto produto) throws
 * ProdutoNaoCadastradoException {
 * buscarProduto(produto.getIdProduto());
 * }
 * 
 * @Override
 * public void deletarProduto(Produto produto) throws
 * ProdutoNaoCadastradoException {
 * if (!produto.remove(produto)) {
 * throw new ProdutoNaoCadastradoException();
 * }
 * }
 * 
 * @Override
 * public Produto buscarProduto(long idProduto) throws
 * ProdutoNaoCadastradoException {
 * for (Produto produto : produto) {
 * if (produto.getIdProduto().equals(idProduto)) {
 * return produto;
 * }
 * }
 * throw new ProdutoNaoCadastradoException();
 * }
 * 
 * @Override
 * public List<Produto> getAll() {
 * return new ArrayList<>(produto);
 * }
 * }
 */