package repository.pessoa;

import model.pessoa.Funcionario;
import model.pessoa.Pessoa;
import model.pessoa.Cliente;
import java.util.ArrayList;

public interface RepositorioPessoa {

  // métodos de funcionario
  void criarFuncionario(Pessoa Funcionario) throws CpfCadastradoException, PessoaNaoCadastradaException;
  
  void alterarFuncionario(Pessoa funcionario) throws PessoaNaoCadastradaException;

  void deletarFuncionario(Pessoa funcionario) throws PessoaNaoCadastradaException;

  Pessoa buscarFuncionario(String cpf) throws PessoaNaoCadastradaException;

  // métodos de cliente
  void criarCliente(Pessoa cliente) throws CpfCadastradoException, PessoaNaoCadastradaException;
  
  void alterarCliente(Pessoa cliente) throws PessoaNaoCadastradaException;

  void deletarCliente(Pessoa cliente) throws PessoaNaoCadastradaException;

  Pessoa buscarCliente(String cpf) throws PessoaNaoCadastradaException;

  ArrayList<Pessoa> getAll();

}