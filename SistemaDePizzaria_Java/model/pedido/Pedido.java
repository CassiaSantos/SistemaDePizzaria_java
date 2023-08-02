package model.pedido;

import model.pessoa.Pessoa;
import java.util.ArrayList;
import java.io.Serializable;

public class Pedido implements Serializable {
  private Long numeroPedido;
  private String dataHora;
  private ArrayList<ItemPedido> ListaItens;
  private Pessoa cliente;
  private Pessoa endEntrega;
  private Pessoa entregador;
  private boolean statusEntrega;

  // Método Construtor:
        public Pedido( String dataHora, ArrayList<ItemPedido> ListaItens,  Pessoa cliente, Pessoa endEntrega, Pessoa entregador,Boolean statusEntrega){
            this.numeroPedido = null;
            this.dataHora = dataHora;
            this.ListaItens = ListaItens;
            this.cliente = cliente;
            this.endEntrega = endEntrega;
            this.entregador = entregador;
            this.statusEntrega = statusEntrega;
        }

  // Métodos Acessores:
  public Long getNumeroPedido() {
    return this.numeroPedido;
  }

  public void setNumeroPedido(long numeroPedido) {
    this.numeroPedido = numeroPedido;
  }

  public String getDataHora() {
    return this.dataHora;
  }

  public void setDataHora(String dataHora) {
    this.dataHora = dataHora;
  }

  // acesso a lista item pedido
  public ArrayList<ItemPedido> getListaItens() {
    return this.ListaItens;
  }

  public void setListaItens(ArrayList<ItemPedido> ListaItens) {
    this.ListaItens = ListaItens;
  }

  // termino do asseso a lista
  public Pessoa getCliente() {
		//Alteração devido a versão do java 1.5
		
    // return this.cliente;
		return this.cliente;
  }

  public void setCliente(Pessoa cliente) {
    this.cliente = cliente;
  }

  public Pessoa getEndEntrega() {
		//Alteração devido a versão do java 1.5
    // return this.endEntrega;
		return this.endEntrega;
  }

  public void setEndEntrega(Pessoa endEntrega) {
    this.endEntrega = endEntrega;
  }

  public Pessoa getEntregador() {
    return this.entregador;
  }

  public void setEntregador(Pessoa entregador) {
    this.entregador = entregador;
  }

  public boolean isStatusEntrega() {
    return statusEntrega;
  }

  public void setStatusEntrega(boolean statusEntrega) {
    this.statusEntrega = statusEntrega;
  }

  // Outros métodos:
  public double totalConta() {

    double total = 0;

    for (ItemPedido item : ListaItens) 
    {
      double preco = item.getValorItem();
      int quantidade = item.getQuantItem();

      total += preco * quantidade;
    }

    return total;
  }

   public void imprimirPedido() {

      System.out.printf("****************************************\n");
      System.out.printf("*          Impressão do Pedido         *\n");
      System.out.printf("****************************************\n");
      System.out.println("Número do pedido: " + getNumeroPedido());
      System.out.println("Cliente: " + cliente.getNome());
      System.out.println("Endereço de entrega: " + endEntrega.getEndereco());
      System.out.println("Data e hora: " + getDataHora());
      System.out.printf("****************************************\n");
      System.out.println("Lista de produtos:");
      for (ItemPedido item : getListaItens()) {
          Produto produto = item.getProduto();
          System.out.println("-" + produto.getNomeProduto() + " | R$: " + produto.getValorProduto() + " | " + "Quant:"+ item.getQuantItem());
      }
      System.out.printf("****************************************\n");
      System.out.println("Total da conta: " + totalConta());
      System.out.println("Entregador: " + entregador.getNome());
      System.out.println("Status de entrega: " + (statusEntrega ? "Entregue" : "Pendente"));
      System.out.printf("****************************************\n");
  }
  
    
}