package repository.pedido;

import model.pedido.Pedido;

import java.util.ArrayList;

public interface RepositorioPedido {
    void criarPedido(Pedido pedido) throws PedidoCadastradoException;

    void alterarPedido(Pedido pedido) throws PedidoNaoCadastradoException;

    void deletarPedido(Pedido pedido) throws PedidoNaoCadastradoException;

    Pedido buscarPedido(long numeroPedido) throws PedidoNaoCadastradoException;

    ArrayList<Pedido> getAll();
}
