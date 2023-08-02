package repository.pedido;

public class PedidoCadastradoException extends Exception{
    PedidoCadastradoException(){
        super("Pedido já Cadastrado!");
    }
}
