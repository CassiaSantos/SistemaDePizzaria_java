package repository.pedido;

public class PedidoNaoCadastradoException extends Exception {

  public PedidoNaoCadastradoException() {
    super("Pedido não Cadastrado!");
  }
}
