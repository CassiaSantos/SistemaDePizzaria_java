package facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import model.pedido.*;
import model.pessoa.*;
import repository.pedido.*;
import repository.pessoa.*;
import repository.produto.*;
import facade.PizzariaFacadeException;

public class PizzariaFacade implements Serializable {

  // Arquivo para salvar os dados
  private final File FILE = new File("pizzaria.dat");

  private RepositorioPessoaLista repositorioPessoaLista;
  private RepositorioPedidoLista repositorioPedidoLista;
  private RepositorioProdutoLista repositorioProdutoLista;
  private RepositorioItemPedidoLista repositorioItemPedidoLista;

  /* Padrão de Projeto Singleton */

  // Atributo estático que vai manter a única instância da classe
  private static PizzariaFacade instance = null;

  // Contrutor deve ser privado garantindo que não
  // pode ser chamado de fora da classe
  private PizzariaFacade() throws PizzariaFacadeException {
    if (FILE.exists()) {
      loadData();
    } else {
      // colocar aqui os outros repositórios:
      repositorioPessoaLista = new RepositorioPessoaLista();
      repositorioPedidoLista = new RepositorioPedidoLista();
      repositorioProdutoLista = new RepositorioProdutoLista();
      repositorioItemPedidoLista = new RepositorioItemPedidoLista();
    }
  }

  // Método getInstance, responsável por fornecer a única
  // instância da classe
  public static PizzariaFacade getInstance() throws PizzariaFacadeException {
    if (instance == null) {
      instance = new PizzariaFacade();
    }
    return instance;
  }

  // -------------------- ITEMPEDIDOLISTA----------------------------

  public ArrayList<ItemPedido> findAllItemPedido() throws ItemPedidoNaoCadastradoException {
    return repositorioItemPedidoLista.buscarItensPedidos();
  }

  public void addItemPedido(Produto produto, int qtd) {

    repositorioItemPedidoLista.inserirItemPedido(produto, qtd);
  }

  public void updateItemPedido(ItemPedido itemPedido, int qtd) throws ItemPedidoNaoCadastradoException {
    repositorioItemPedidoLista.alterarItemPedido(itemPedido, qtd);

  }

  // -------------------------PEDIDOLISTA-------------------------

  public ArrayList<Pedido> findAllPedido() {
    return repositorioPedidoLista.getAll();
  }

  public ArrayList<Pedido> findAllByCpf(String cpf) {
    return repositorioPedidoLista.getAll(cpf);
  }

  public Pedido findPedido(long numeroPedido) throws PedidoNaoCadastradoException {
    return repositorioPedidoLista.buscarPedido(numeroPedido);
  }

  public void create(Pedido pedido) throws PedidoCadastradoException {
    repositorioPedidoLista.criarPedido(pedido);
  }

  public void update(Pedido pedido) throws PedidoNaoCadastradoException {
    // Não há necessidade de autalizar o objeto na memória
  }

  public void delete(Pedido pedido) throws PedidoNaoCadastradoException {
    repositorioPedidoLista.deletarPedido(pedido);
  }

  // ------------------------- PESSOALISTA ---------------------------------------

  // RepositorioPessoaLista repositorioPessoaLista = new RepositorioPessoaLista();

  public ArrayList<Pessoa> findAllPessoa() {
    return repositorioPessoaLista.getAll();
  }

  public Pessoa findFuncionarioEntregador() {
    return repositorioPessoaLista.buscarFuncionarioRand();
  }

  public Pessoa findFuncionarioByCpf(String cpf) throws PessoaNaoCadastradaException {
    return repositorioPessoaLista.buscarFuncionario(cpf);
  }

  public void createFuncionario(Pessoa funcionario) throws CpfCadastradoException, PessoaNaoCadastradaException {
    repositorioPessoaLista.criarFuncionario(funcionario);
  }
  
  public void updateFuncionario(Pessoa funcionario) throws PessoaNaoCadastradaException, CpfCadastradoException {
    
  }
  
  public void deleteFuncionarioByCpf(Pessoa funcionario) throws PessoaNaoCadastradaException {
    repositorioPessoaLista.deletarFuncionario(funcionario);
  }

  // ---------------------------------------------------------------------------------

  public Cliente findClienteByCpf(String cpf) throws PessoaNaoCadastradaException {
    return repositorioPessoaLista.buscarCliente(cpf);
  }

  public void createCliente(Cliente cliente) throws CpfCadastradoException, PessoaNaoCadastradaException {
    repositorioPessoaLista.criarCliente(cliente);
  }
  
  public void updateCliente(Cliente cliente) throws PessoaNaoCadastradaException, CpfCadastradoException {
    
  }
  
  public void deleteClienteByCpf(Cliente cliente) throws PessoaNaoCadastradaException {
    repositorioPessoaLista.deletarCliente(cliente);
  }

  // ----------------- PRODUTOLISTA ----------------------------------

  public ArrayList<Produto> findAllProdutos() {
    return repositorioProdutoLista.getAll();
  }

  public Produto findProduto(Long id) throws ProdutoNaoCadastradoException {
    return repositorioProdutoLista.buscaProdutoId(id);
  }

  public ArrayList<Produto> findByCat(String categoria) throws CategoriaNaoExisteException {
    return repositorioProdutoLista.buscarProdutoCat(categoria);
  }

  public void create(Produto produto) {
    repositorioProdutoLista.inserirProduto(produto);
  }

  public void update(Produto produto) throws ProdutoNaoCadastradoException {
    Produto produtoUpdate = repositorioProdutoLista.buscaProdutoId(produto.getIdProduto());
    produtoUpdate.setNomeProduto(produto.getNomeProduto());
    produtoUpdate.setValorProduto(produto.getValorProduto());
    produtoUpdate.setCategoriaProduto(produto.getCategoriaProduto());
    repositorioProdutoLista.alterarProduto(produtoUpdate);
  }

  public void delete(Produto produto) throws ProdutoNaoCadastradoException {
    repositorioProdutoLista.deletarProduto(produto);
  }

  // --------------- lEITURA E FECHAMENTO DO ARQUIVO --------------
  private void loadData() throws PizzariaFacadeException {
    try {
      FileInputStream f = new FileInputStream(FILE);
      ObjectInputStream o = new ObjectInputStream(f);

      // colocar aqui todos os repositórios:
      repositorioPessoaLista = (RepositorioPessoaLista) o.readObject();
      repositorioProdutoLista = (RepositorioProdutoLista) o.readObject();
      repositorioPedidoLista = (RepositorioPedidoLista) o.readObject();
      repositorioItemPedidoLista = (RepositorioItemPedidoLista) o.readObject();

      o.close();
      f.close();
      
    } catch (Exception e) {
      throw new PizzariaFacadeException("Erro ao carregar dados do arquivo", e);
    }
  }

  public void exit() throws PizzariaFacadeException {
    try {
      FileOutputStream f = new FileOutputStream(FILE);
      ObjectOutputStream o = new ObjectOutputStream(f);

      // Salvamento dos dados
      o.writeObject(repositorioPessoaLista);
      o.writeObject(repositorioProdutoLista);
      o.writeObject(repositorioPedidoLista);
      o.writeObject(repositorioItemPedidoLista);

      o.close();
      f.close();
    } catch (IOException e) {
      throw new PizzariaFacadeException("Erro ao gravar dados no arquivo", e);
    }
  }

 
}