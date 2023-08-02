package repository.pedido;

import model.pedido.ItemPedido;
import model.pedido.Produto;
import repository.produto.CategoriaNaoExisteException;

import java.util.ArrayList;

public interface RepositorioItemPedido {
	void inserirItemPedido(Produto produto,int qtd);

    void alterarItemPedido(ItemPedido itemPedido, int qtd) throws ItemPedidoNaoCadastradoException;

    void deletarItemPedido(ItemPedido itemPedido) throws ItemPedidoNaoCadastradoException;
    

    ArrayList<ItemPedido> buscarItensPedidos() throws ItemPedidoNaoCadastradoException;

    ArrayList<ItemPedido> buscarItensPedidosByCategoria(String categoria) throws CategoriaNaoExisteException;

    ItemPedido buscarItemPedido(Produto produto) throws ItemPedidoNaoCadastradoException;
    }
