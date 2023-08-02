package repository.produto;

import model.pedido.Produto;
import java.util.ArrayList;

public interface RepositorioProduto {

   void inserirProduto(Produto produto);

    void alterarProduto(Produto produto) throws ProdutoNaoCadastradoException;

    void deletarProduto(Produto produto) throws ProdutoNaoCadastradoException;

    ArrayList<Produto> buscarProdutoCat(String categoria) throws CategoriaNaoExisteException;

    Produto buscaProdutoId(Long id) throws ProdutoNaoCadastradoException;

    ArrayList<Produto> getAll();
}
