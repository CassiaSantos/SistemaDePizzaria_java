package repository.pedido;

public class ItemPedidoNaoCadastradoException extends Exception {
  public ItemPedidoNaoCadastradoException() {
    super("Item não cadastrado");
  }
}
