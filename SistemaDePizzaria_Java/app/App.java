package app;

import model.pedido.Pedido;
import model.pedido.Produto;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;
import facade.PizzariaFacadeException;

import facade.PizzariaFacade;
import repository.pedido.ItemPedidoNaoCadastradoException;
import repository.pedido.PedidoCadastradoException;
import repository.pessoa.CpfCadastradoException;
import repository.pessoa.PessoaNaoCadastradaException;
import repository.produto.CategoriaNaoExisteException;
import repository.produto.ProdutoNaoCadastradoException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class App {
  private static PizzariaFacade pizzariaFacade;
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws PizzariaFacadeException, CpfCadastradoException,
      PessoaNaoCadastradaException, ProdutoNaoCadastradoException, CategoriaNaoExisteException, InterruptedException,
      ItemPedidoNaoCadastradoException, PedidoCadastradoException {

    try {
      System.out.printf("\nIniciando Sistema da Pizzaria...\n");
      Thread.sleep(1000);
      pizzariaFacade = PizzariaFacade.getInstance();

      limpaTela();

      int opcao;
      do {
        System.out.printf("\n");
        System.out.printf("****************************************\n");
        System.out.printf("*                                      *\n");
        System.out.printf("*               PIZARRIA               *\n");
        System.out.printf("*                                      *\n");
        System.out.printf("****************************************\n");
        System.out.printf("****************************************\n");
        System.out.printf("*            Menu principal            *\n");
        System.out.printf("****************************************\n");
        System.out.printf("*                                      *\n");
        System.out.printf("*  (1) Cadastro de Pedido              *\n");
        System.out.printf("*  (2) Cadastro de Cliente             *\n");
        System.out.printf("*  (3) Cadastro de Produto             *\n");
        System.out.printf("*  (4) Cadastro de Funcionario         *\n");
        System.out.printf("*  (0) Encerrar Programa               *\n");
        System.out.printf("*                                      *\n");
        System.out.printf("****************************************\n");
        System.out.printf("Opção: ");
        opcao = scanner.nextInt();

        if (opcao == 0 || opcao < 0 || opcao > 5) {
          System.out.printf("\nEncerrando Sistema da Pizzaria...\n");
          Thread.sleep(1000);
          break;
        }

        else if (opcao == 1) {
          cadastroPedido();
        }

        else if (opcao == 2) {
          cadastroCliente();
        }

        else if (opcao == 3) {
          cadastroProduto();
        }

        else if (opcao == 4) {
          cadastrofuncionario();
        }

      } while (opcao != 0);
      pizzariaFacade.exit();
    } catch (PizzariaFacadeException e) {
      System.err.println("Erro ao carregar dados");
      e.printStackTrace();
    }
    System.out.println("Programa terminado");
    Thread.sleep(1000);

  }

  private static void limpaTela() {
    for (int i = 0; i < 40; i++) {
      System.out.println();
    }
  }

  private static void cadastroPedido() throws CategoriaNaoExisteException, PessoaNaoCadastradaException,
      InterruptedException, ItemPedidoNaoCadastradoException, PedidoCadastradoException {
    limpaTela();

    scanner.nextLine();
    System.out.printf("\n");
    System.out.printf("****************************************\n");
    System.out.printf("*          Cadastro de Pedido          *\n");
    System.out.printf("****************************************\n");
    System.out.printf("*           Login Funcionario          *\n");
    System.out.printf("****************************************\n");
    System.out.printf("*                                      *\n");
    System.out.printf("Digite seu CPF: ");
    String cpf = scanner.next();
    Pessoa funcionario = pizzariaFacade.findFuncionarioByCpf(cpf);
    ;
    System.out.printf("****************************************\n");
    System.out.println("Nome: " + funcionario.getNome());
    System.out.println("Cargo: " + ((Funcionario) funcionario).getCargoFuncionario());
    System.out.printf("****************************************\n");
    Thread.sleep(1000);
    limpaTela();

    int op;
    do {
      System.out.printf("\n");
      System.out.printf("****************************************\n");
      System.out.printf("*          Cadastro de Pedido          *\n");
      System.out.printf("****************************************\n");
      System.out.printf("*                                      *\n");
      System.out.printf("*  (1) Pedido                          *\n");
      System.out.printf("*  (0) Voltar ao Menu Principal        *\n");
      System.out.printf("*                                      *\n");
      System.out.printf("****************************************\n");
      System.out.printf("Opção: ");
      op = scanner.nextInt();
      scanner.nextLine();
      System.out.printf("\n");

      if (op == 0) {
        System.out.printf("\nVoltando ao Menu Anterior...\n");
        Thread.sleep(1000);
        limpaTela();
        break;
      }

      if (op == 1) {
        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*              Novo Pedido             *\n");
        System.out.printf("****************************************\n");
        System.out.printf("*         Cardapio de Produtos         *\n");
        System.out.printf("****************************************\n");
        System.out.printf("*                                      *\n");
        System.out.printf("*  (1) Pizzas                          *\n");
        System.out.printf("*  (2) Bebidas                         *\n");
        System.out.printf("*  (3) Finalizar pedido                *\n");
        System.out.printf("*  (0) Voltar ao Menu Anterior         *\n");
        System.out.printf("*                                      *\n");
        System.out.printf("****************************************\n");
        System.out.printf("Opção: ");
        int subOp1 = scanner.nextInt();
        scanner.nextLine();

        do {
          if (subOp1 == 0 || subOp1 < 0 || subOp1 > 3) {
            System.out.printf("\nVoltando ao Menu Anterior...\n");
            Thread.sleep(1000);
            limpaTela();
            break;
          }

          if (subOp1 == 1) {
            metodoAdicionarPizzaPed();
            break;
          }

          if (subOp1 == 2) {
            metodoAdicionarbebidasPed();
            break;
          }

          if (subOp1 == 3) {
            metodoFinalizarPed();
            break;

          }

        } while (subOp1 > 0 && subOp1 < 4);

      }

      else if (op == 2) {
        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*          Pedidos Realizados          *\n");
        System.out.printf("****************************************\n");
        ArrayList<Pedido> listPedidos = pizzariaFacade.findAllPedido();

        if (listPedidos.size() == 0) {
          System.out.printf("\nNenhum Pedido Realizado!\n");
        } else {
          for (Pedido pedido : listPedidos) {
            pedido.imprimirPedido();
          }
        }

        System.out.printf("\nPressione <ENTER> para Voltar ao Menu Principal\n");
        scanner.nextLine();
        limpaTela();

      }
    } while (op != 0);
  }

  private static void cadastroCliente()
      throws CpfCadastradoException, PessoaNaoCadastradaException, InterruptedException {
    limpaTela();
    int op2;

    do {

      System.out.printf("\n");
      System.out.printf("****************************************\n");
      System.out.printf("*          Cadastro de Cliente         *\n");
      System.out.printf("****************************************\n");
      System.out.printf("*                                      *\n");
      System.out.printf("*  (1) Cadastrar Novo Cliente          *\n");
      System.out.printf("*  (2) Consultar Clientes              *\n");
      System.out.printf("*  (4) Excluir Cliente                 *\n");
      System.out.printf("*  (0) Voltar ao Menu Principal        *\n");
      System.out.printf("*                                      *\n");
      System.out.printf("****************************************\n");
      System.out.printf("Opção: ");
      op2 = scanner.nextInt();
      scanner.nextLine();
      System.out.printf("\n");

      if (op2 == 0) {
        System.out.printf("\nVoltando ao Menu Anterior...\n");
        Thread.sleep(1000);
        limpaTela();
      }

      if (op2 == 1) {
        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*             Novo Cliente             *\n");
        System.out.printf("****************************************\n");
        System.out.printf("Nome: ");
        String nomeCli = scanner.nextLine();
        System.out.printf("CPF: ");
        String cpfCli = scanner.nextLine();
        System.out.printf("Telefone: ");
        String telefoneCli = scanner.nextLine();
        System.out.printf("Endereço: ");
        String enderecoCli = scanner.nextLine();

        Pessoa cliente = new Cliente(nomeCli, cpfCli, telefoneCli, enderecoCli);
        pizzariaFacade.createCliente((Cliente) cliente);

        System.out.printf("\n");
        System.out.printf("****************************************\n");
        System.out.printf("*    Cliente Cadastrado com Sucesso!   *\n");
        System.out.printf("****************************************\n");
        System.out.printf("\n");
        Thread.sleep(1000);
        limpaTela();
      }

      if (op2 == 2) {
        limpaTela();

        System.out.printf("****************************************\n");
        System.out.printf("*          Consultar Clientes          *\n");
        System.out.printf("****************************************\n");
        ArrayList<Pessoa> listPessoas = pizzariaFacade.findAllPessoa();
        ArrayList<Cliente> listClientes = new ArrayList<>();

        for (Pessoa p : listPessoas) {
          if (p instanceof Cliente) {
            listClientes.add((Cliente) p);
          }
        }

        for (Cliente cliente : listClientes) {
          System.out.println("Nome: " + cliente.getNome());
          System.out.println("CPF: " + cliente.getCpf());
          System.out.println("Telefone: " + cliente.getTelefone());
          System.out.println("Endereço: " + cliente.getEndereco());
          System.out.printf("****************************************\n");
        }

        if (listClientes.size() == 0) {
          System.out.println("Nenhum Cliente Cadastrado!");
          Thread.sleep(1000);
        }

        System.out.printf("Pressione <ENTER> para Voltar ao Menu Principal\n");
        scanner.nextLine();

        limpaTela();

      }

    
      if (op2 == 4) {
        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*           Excluir Clientes           *\n");
        System.out.printf("****************************************\n");
        System.out.println();
        System.out.print("CPF do Cliente: ");
        String cpfDel = scanner.nextLine();
        try {
          Pessoa funcionarioDel = pizzariaFacade.findClienteByCpf(cpfDel);
          System.out.println();
          System.out.println("Nome: " + funcionarioDel.getNome());
          System.out.println("CPF: " + funcionarioDel.getCpf());
          System.out.println("Telefone: " + funcionarioDel.getTelefone());
          System.out.println("Endereço: " + funcionarioDel.getEndereco());
          System.out.printf("****************************************\n");
          System.out.println();

          System.out.print("Excluir cliente? (1- Sim | 2- Não)?");
          System.out.printf("Opção: ");
          int resposta = scanner.nextInt();

          if (resposta == 1) {
            pizzariaFacade.deleteClienteByCpf((Cliente) funcionarioDel);
            System.out.println("\nCliente excluído!\n");
          }

          else {
            System.out.printf("\nCliente Não Excluido!\n");
          }

        } catch (Exception ex) {
          System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
      }
    } while (op2 != 0);
  }

  private static void cadastroProduto() throws ProdutoNaoCadastradoException, InterruptedException {
    limpaTela();
    int op3;
    do {
      System.out.printf("\n");
      System.out.printf("****************************************\n");
      System.out.printf("*         Cadastro de Produtos         *\n");
      System.out.printf("****************************************\n");
      System.out.printf("*                                      *\n");
      System.out.printf("*  (1) Cadastrar Novo Produto          *\n");
      System.out.printf("*  (2) Consultar Produtos              *\n");
      System.out.printf("*  (4) Excluir Produto                 *\n");
      System.out.printf("*  (0) Voltar ao Menu Principal        *\n");
      System.out.printf("*                                      *\n");
      System.out.printf("****************************************\n");
      System.out.printf("Opção: ");
      op3 = scanner.nextInt();
      scanner.nextLine();
      System.out.printf("\n");

      if (op3 == 0) {
        System.out.printf("\nVoltando ao Menu Anterior...\n");
        Thread.sleep(1000);
        limpaTela();
      }

      if (op3 == 1) {
        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*             Novo Produto             *\n");
        System.out.printf("****************************************\n");
        System.out.printf("Nome do Produto: ");
        String nomeProd = scanner.nextLine();
        System.out.printf("Categoria: 1 - Pizza | 2 - Bebida\n");
        System.out.printf("Opção: ");
        int cate = scanner.nextInt();
        System.out.printf("Valor do Produto: R$ ");
        double valorProd = scanner.nextDouble();

        String categProd;

        if (cate == 1) {
          categProd = "Pizza";
          Produto produto = new Produto(nomeProd, categProd, valorProd);
          pizzariaFacade.create(produto);
        }

        if (cate == 2) {
          categProd = "Bebida";
          Produto produto = new Produto(nomeProd, categProd, valorProd);
          pizzariaFacade.create(produto);
        }

        System.out.printf("\n");
        System.out.printf("****************************************\n");
        System.out.printf("*    Produto Cadastrado com Sucesso!   *\n");
        System.out.printf("****************************************\n");
        System.out.printf("\n");
        Thread.sleep(1000);
        limpaTela();
      }

      else if (op3 == 2) {

        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*           Lista de Produtos          *\n");
        System.out.printf("****************************************\n");
        ArrayList<Produto> listProdutos = pizzariaFacade.findAllProdutos();

        for (Produto produto : listProdutos) {
          System.out.println("Id: " + produto.getIdProduto());
          System.out.println("Nome: " + produto.getNomeProduto());
          System.out.println("Categoria: " + produto.getCategoriaProduto());
          System.out.println("Valor: " + produto.getValorProduto());
          System.out.printf("****************************************\n");
        }

        if (listProdutos.size() == 0) {
          System.out.println("Nenhum Produto Cadastrado!");
          Thread.sleep(1000);
        }

        System.out.printf("Pressione <ENTER> para Voltar ao Menu Principal\n");
        scanner.nextLine();
        Thread.sleep(1000);
        limpaTela();
      }

    

      else if (op3 == 4) {
        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*           Excluir Produtos           *\n");
        System.out.printf("****************************************\n");
        System.out.println();
        System.out.print("ID do Produto: ");
        Long produtoDel = scanner.nextLong();
        scanner.nextLine();
        System.out.println();
        try {
          Produto produtoDel1 = pizzariaFacade.findProduto(produtoDel);
          System.out.println("Id: " + produtoDel1.getIdProduto());
          System.out.println("Nome: " + produtoDel1.getNomeProduto());
          System.out.println("Categoria: " + produtoDel1.getCategoriaProduto());
          System.out.println("Valor: " + produtoDel1.getValorProduto());
          System.out.printf("****************************************\n");
          System.out.println();

          System.out.print("Excluir o Produto? (1- Sim | 2- Nao\n)?");
          System.out.printf("Opção: ");
          int resposta = scanner.nextInt();

          if (resposta == 1) {
            pizzariaFacade.delete(produtoDel1);
            System.out.println("\nProduto excluído!\n");
          }

          else {
            System.out.printf("\nProduto não excluido\n");
          }

        } catch (Exception ex) {
          System.err.println(ex.getMessage());
        }
      }

    } while (op3 != 0);
  }

  private static void cadastrofuncionario()
      throws PizzariaFacadeException, CpfCadastradoException, PessoaNaoCadastradaException, InterruptedException {
    limpaTela();
    int op4;
    do {
      System.out.printf("\n");
      System.out.printf("****************************************\n");
      System.out.printf("*       Cadastro de Funcionarios       *\n");
      System.out.printf("****************************************\n");
      System.out.printf("*                                      *\n");
      System.out.printf("*  (1) Cadastrar Novo Funcionario      *\n");
      System.out.printf("*  (2) Consultar Funcionarios          *\n");
      System.out.printf("*  (4) Excluir Funcionario             *\n");
      System.out.printf("*  (0) Voltar ao Menu Principal        *\n");
      System.out.printf("*                                      *\n");
      System.out.printf("****************************************\n");
      System.out.printf("Opção: ");
      op4 = scanner.nextInt();
      scanner.nextLine();
      System.out.printf("\n");

      if (op4 == 0) {
        System.out.printf("\nVoltando ao Menu Anterior...\n");
        Thread.sleep(1000);
        limpaTela();
      }

      if (op4 == 1) {
        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*           Novo Funcionario           *\n");
        System.out.printf("****************************************\n");
        System.out.printf("Nome: ");
        String nomeFunc = scanner.nextLine();
        System.out.printf("CPF: ");
        String cpfFunc = scanner.nextLine();
        System.out.printf("Telefone: ");
        String telefoneFunc = scanner.nextLine();
        System.out.printf("Endereço: ");
        String enderecoFunc = scanner.nextLine();
        System.out.printf("Cargo: ");
        String cargoFunc = scanner.nextLine();
        System.out.printf("Salario: R$ ");
        Double salarioFunc = scanner.nextDouble();

        Pessoa funcionario = new Funcionario(nomeFunc, cpfFunc, telefoneFunc, enderecoFunc, cargoFunc, salarioFunc);
        pizzariaFacade.createFuncionario((Funcionario) funcionario);

        System.out.printf("\n");
        System.out.printf("****************************************\n");
        System.out.printf("*  Funcionario Cadastrado com Sucesso! *\n");
        System.out.printf("****************************************\n");
        System.out.printf("\n");
        Thread.sleep(1000);
        limpaTela();
      }

      else if (op4 == 2) {

        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*           Lista Funcionarios         *\n");
        System.out.printf("****************************************\n");
        ArrayList<Pessoa> listPessoas = pizzariaFacade.findAllPessoa();
        ArrayList<Funcionario> listFuncionario = new ArrayList<>();

        for (Pessoa p : listPessoas) {
          if (p instanceof Funcionario) {
            listFuncionario.add((Funcionario) p);
          }
        }
        for (Funcionario funcionario : listFuncionario) {
          System.out.println("Nome: " + funcionario.getNome());
          System.out.println("CPF: " + funcionario.getCpf());
          System.out.println("Cargo: " + funcionario.getCargoFuncionario());
          System.out.println("Salário: " + funcionario.getSalarioFuncionario());
          System.out.printf("****************************************\n");
        }

        if (listFuncionario.size() == 0) {
          System.out.println("Nenhum Funcionario Cadastrado!");
          Thread.sleep(1000);
        }

        System.out.printf("Pressione <ENTER> para Voltar ao Menu Principal\n");
        scanner.nextLine();

        limpaTela();

      }

  

      else if (op4 == 4) {
        limpaTela();
        System.out.printf("****************************************\n");
        System.out.printf("*          Excluir Funcionario         *\n");
        System.out.printf("****************************************\n");
        System.out.println();
        System.out.print("CPF do Funcicionário: ");
        String cpfDel = scanner.nextLine();
        try {
          Pessoa funcionarioDel = pizzariaFacade.findFuncionarioByCpf(cpfDel);
          System.out.println();
          System.out.println("Nome: " + funcionarioDel.getNome());
          System.out.println("CPF: " + funcionarioDel.getCpf());
          System.out.println("Telefone: " + funcionarioDel.getTelefone());
          System.out.println("Endereço: " + funcionarioDel.getEndereco());
          System.out.printf("****************************************\n");
          System.out.println();

          System.out.print("Excluir Funcionário? ( 1 - SIM | 2 - NAO )?\n");
          System.out.printf("Opção: ");
          int resposta = scanner.nextInt();

          if (resposta == 1) {
            pizzariaFacade.deleteFuncionarioByCpf((Funcionario) funcionarioDel);
            System.out.println("\nFuncionario excluído!");
          }

          else {
            System.out.printf("\nFuncionario não Excluido!");
          }

        } catch (Exception ex) {
          System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("tecle <ENTER> para voltar");
        scanner.nextLine();
        scanner.nextLine();
        limpaTela();
      }

    } while (op4 != 0);

  }

  private static void metodoAdicionarPizzaPed() throws CategoriaNaoExisteException, InterruptedException {

    limpaTela();

    ArrayList<Produto> ListBebidas = pizzariaFacade.findByCat("Pizza");

    limpaTela();
    System.out.printf("****************************************\n");
    System.out.printf("*            Cardapio Pizzas           *\n");
    System.out.printf("****************************************\n");
    System.out.printf("*                                      *\n");

    for (int i = 0; i < ListBebidas.size(); i++) {
      Produto pizza = ListBebidas.get(i);
      System.out.println("\nId: " + pizza.getIdProduto());
      System.out.println("Nome: " + pizza.getNomeProduto());
      System.out.println("Valor: " + pizza.getValorProduto());
      System.out.printf("****************************************\n");
    }

    int o;
    System.out.printf("\nAdicionar Pizzas ao Pedido: \n1- Sim | 2- Não\n");
    System.out.printf("Opção: ");
    o = scanner.nextInt();
    scanner.nextLine();

    Long id = (long) 0;

    int r = 0;
    if (o == 1) {
      System.out.printf("\nDigite o ID do Produto para Adicioná-lo ao Pedido: ");
      id = scanner.nextLong();
      limpaTela();
      r = 1;
    }

    if (o != 1) {
      System.out.printf("\nProduto não adicionado ao pedido\n");
      System.out.printf("\nVoltando ao Menu Anterior...\n");
      Thread.sleep(1000);
      limpaTela();
    }

    if (r == 1) {
      for (int i = 0; i < ListBebidas.size(); i++) {
        Produto pizza = ListBebidas.get(i);

        if (id.equals(pizza.getIdProduto())) {
          System.out.printf("\n****************************************\n");
          System.out.println("Id: " + pizza.getIdProduto());
          System.out.println("Nome: " + pizza.getNomeProduto());
          System.out.println("Valor: " + pizza.getValorProduto());
          System.out.printf("****************************************\n");
          System.out.printf("\nAdicionar esse Produto ao pedido? \n1- Sim | 2- Não\n");
          System.out.printf("Opção: ");
          int a = scanner.nextInt();

          if (a == 1) {
            System.out.printf("Qual a quantidade: ");
            int b = scanner.nextInt();
            pizzariaFacade.addItemPedido(pizza, b);
            System.out.printf("\nProduto Adicionado ao pedido!\n");
            Thread.sleep(1000);
            limpaTela();
          }

        }
      }
    }

    else {
      System.out.printf("\nVoltando ao Menu Anterior...\n");
      Thread.sleep(1000);
      limpaTela();
    }

  }

  private static void metodoAdicionarbebidasPed() throws CategoriaNaoExisteException, InterruptedException {

    ArrayList<Produto> ListBebidas = pizzariaFacade.findByCat("Bebida");

    limpaTela();
    System.out.printf("****************************************\n");
    System.out.printf("*            Cardapio Bebidas          *\n");
    System.out.printf("****************************************\n");
    System.out.printf("*                                      *\n");

    for (int i = 0; i < ListBebidas.size(); i++) {
      Produto bebida = ListBebidas.get(i);
      System.out.println("\nId: " + bebida.getIdProduto());
      System.out.println("Nome: " + bebida.getNomeProduto());
      System.out.println("Valor: " + bebida.getValorProduto());
      System.out.printf("****************************************\n");
    }

    int o;
    System.out.printf("\nAdicionar Bedida ao Pedido: \n1- Sim | 2- Não\n");
    System.out.printf("Opção: ");
    o = scanner.nextInt();
    scanner.nextLine();

    Long id = null;

    int r = 0;
    if (o == 1) {
      System.out.printf("\nDigite o ID do Produto para Adicioná-lo ao Pedido: ");
      id = scanner.nextLong();
      limpaTela();
      r = 1;
    }

    if (o != 1) {
      System.out.printf("\nProduto não adicionado ao pedido\n");
      System.out.printf("\nVoltando ao Menu Anterior...\n");
      Thread.sleep(1000);
      limpaTela();
    }

    if (r == 1) {
      for (int i = 0; i < ListBebidas.size(); i++) {
        Produto bebida = ListBebidas.get(i);

        if (id.equals(bebida.getIdProduto())) {
          System.out.printf("\n****************************************\n");
          System.out.println("Id: " + bebida.getIdProduto());
          System.out.println("Nome: " + bebida.getNomeProduto());
          System.out.println("Valor: " + bebida.getValorProduto());
          System.out.printf("****************************************\n");
          System.out.printf("\nAdicionar esse Produto ao pedido? \n1- Sim | 2- Não\n");
          System.out.printf("Opção: ");
          int a = scanner.nextInt();

          if (a == 1) {
            System.out.printf("Qual a quantidade: ");
            int b = scanner.nextInt();
            pizzariaFacade.addItemPedido(bebida, b);
            System.out.printf("\nProduto Adicionado ao pedido!\n");
            Thread.sleep(1000);
            limpaTela();
          }
        }
      }
    }

    else {
      System.out.printf("\nVoltando ao Menu Anterior...\n");
      Thread.sleep(1000);
      limpaTela();
    }
  }

  private static void metodoFinalizarPed() throws PedidoCadastradoException, InterruptedException,
      ItemPedidoNaoCadastradoException, PessoaNaoCadastradaException {
    limpaTela();
    System.out.printf("****************************************\n");
    System.out.printf(" Deseja finalizar o pedido \n 1- SIM | 2- NAO\n");
    System.out.printf("****************************************\n");
    System.out.printf("Opção: ");
    int finalizar = scanner.nextInt();
    limpaTela();

    scanner.nextLine();
    if (finalizar == 1) {
      System.out.printf("****************************************\n");
      System.out.printf("*       Finalizando o seu pedido       *\n");
      System.out.printf("****************************************\n");

      Calendar dataHora = Calendar.getInstance();
      SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      String dataHoraFormatada = formatador.format(dataHora.getTime());

      System.out.printf("Digite o Cpf do cliente: ");
      String cpfCli = scanner.nextLine();
      limpaTela();

      Cliente clientePed = pizzariaFacade.findClienteByCpf(cpfCli);
      if (cpfCli.equals(clientePed.getCpf())) {

        System.out.printf("****************************************\n");
        System.out.printf("*          Cliente com esse CPF        *\n");
        System.out.printf("****************************************\n");
        System.out.println("Nome: " + clientePed.getNome());
        System.out.println("CPF: " + clientePed.getCpf());
        System.out.println("Telefone: " + clientePed.getTelefone());
        System.out.println("Endereço: " + clientePed.getEndereco());
        System.out.printf("****************************************\n");
        System.out.printf("Adicionar esse cliente ao Pedido?\n1- Sim | 2- Não\n");
        System.out.printf("Opção: ");
        int m = scanner.nextInt();
        limpaTela();

        if (m == 1) {


          Pedido pedidoFinalizado = new Pedido(dataHoraFormatada, pizzariaFacade.findAllItemPedido(), clientePed, clientePed, pizzariaFacade.findFuncionarioEntregador(), false);
          pizzariaFacade.create(pedidoFinalizado);
          limpaTela();
          pedidoFinalizado.imprimirPedido();


          

          System.out.printf("\nPressione <ENTER> para Voltar ao Menu Principal\n");
          scanner.nextLine();
          scanner.nextLine();
          Thread.sleep(1000);
          limpaTela();
        }

        else {
          System.out.printf("\nVoltando ao Menu Anterior...\n");
          scanner.nextLine();
          Thread.sleep(1000);
          limpaTela();
        }
      }

    }
  }

}