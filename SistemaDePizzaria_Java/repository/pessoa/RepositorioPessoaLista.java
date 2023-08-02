package repository.pessoa;

import model.pessoa.Pessoa;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import pattern.IdGeneratorStrategy;

public class RepositorioPessoaLista implements RepositorioPessoa, Serializable {

  ArrayList<Pessoa> pessoaList;
    IdGeneratorStrategy idGenerator;

    public RepositorioPessoaLista() {
        pessoaList = new ArrayList<>();
        idGenerator = new SequencialPessoaIdGeneratorStrategy();
    }

    // ------------------------------------------ Métodos de funcionario ------------------------------------------
    @Override
    public void criarFuncionario(Pessoa funcionario) throws CpfCadastradoException, PessoaNaoCadastradaException {
        if (funcionario.getCpf() == null) {
            funcionario.setCpf(idGenerator.nextId());
        }
        try {
            while (buscarFuncionario(funcionario.getCpf()) != null) {
                funcionario.setCpf(idGenerator.nextId());
            }
        } catch ( PessoaNaoCadastradaException e) {
            pessoaList.add(funcionario);
        }
    }

    @Override
    public void alterarFuncionario(Pessoa funcionario) throws PessoaNaoCadastradaException {
        
    }

    @Override
    public void deletarFuncionario(Pessoa funcionario) throws PessoaNaoCadastradaException {
        if (! pessoaList.remove(funcionario)) {
            throw new PessoaNaoCadastradaException();
        }
    }

    public Pessoa buscarFuncionario(String cpf) throws PessoaNaoCadastradaException {
        for (Pessoa funcionario : pessoaList) {
            if (funcionario.getCpf().equals(cpf)){
            return funcionario;
            }
        }
        throw new PessoaNaoCadastradaException();
    }

        public Pessoa buscarFuncionarioRand(){
        ArrayList<Pessoa> listFunc = new ArrayList<>();
        ArrayList<Pessoa> lisPessoa = getAll();
        for (Pessoa pessoa: lisPessoa) {
            if (pessoa instanceof Funcionario && ((Funcionario) pessoa).getCargoFuncionario().equals("Entregador")){
                listFunc.add(pessoa);
            }
        }
        Random random = new Random();
        int num = random.nextInt(listFunc.size());
        return listFunc.get(num);

    }
    
// ------------------------------------------ Métodos de Cliente ------------------------------------------
    
    @Override
    public void criarCliente(Pessoa cliente) throws CpfCadastradoException, PessoaNaoCadastradaException {
        if (cliente.getCpf() == null) {
            cliente.setCpf(idGenerator.nextId());
        }
        try {
            while (buscarCliente(cliente.getCpf()) != null) {
                cliente.setCpf(idGenerator.nextId());
            }
        } catch ( PessoaNaoCadastradaException e) {
            pessoaList.add(cliente);
        }
    }

    @Override
    public void alterarCliente(Pessoa cliente) throws PessoaNaoCadastradaException {
        
    }

    @Override
    public void deletarCliente(Pessoa cliente) throws PessoaNaoCadastradaException {
        if (! pessoaList.remove(cliente)) {
            throw new PessoaNaoCadastradaException();
        }
    }

    public Cliente buscarCliente(String cpf) throws PessoaNaoCadastradaException {
        for (Pessoa cliente : pessoaList) {
            if (cliente.getCpf().equals(cpf)){
            return (Cliente) cliente;
            }
        }
        throw new PessoaNaoCadastradaException();
    }

    @Override
    public ArrayList<Pessoa> getAll() {
        return pessoaList;
    }

}