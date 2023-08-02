package repository.pedido;

import model.pedido.ItemPedido;
import model.pedido.Produto;
import repository.produto.CategoriaNaoExisteException;

import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioItemPedidoLista implements RepositorioItemPedido, Serializable {
    ArrayList<ItemPedido> itensPedidos;

    public RepositorioItemPedidoLista() {
        this.itensPedidos = new ArrayList<>();
    }
    @Override
    public void inserirItemPedido(Produto produto, int qtd) {
       ItemPedido itemPedido = new ItemPedido(produto, produto.getValorProduto(),qtd);
       itensPedidos.add(itemPedido);

    }

    @Override
    public void alterarItemPedido(ItemPedido itemPedido, int qtd) throws ItemPedidoNaoCadastradoException {
        for (ItemPedido item : itensPedidos) {
            if (item.getProduto().equals(itemPedido)){
                item.setQuantItem(qtd);
            }
        }
    }

    @Override
    public void deletarItemPedido(ItemPedido itemPedido) throws ItemPedidoNaoCadastradoException {
        for (ItemPedido item: itensPedidos) {
            if (item.equals(itemPedido)){
                itensPedidos.remove(item);
            }
        }
    }

    @Override
    public ArrayList<ItemPedido> buscarItensPedidos() throws ItemPedidoNaoCadastradoException {
        return itensPedidos;
    }
    

    @Override
    public ArrayList<ItemPedido> buscarItensPedidosByCategoria(String categoria) throws CategoriaNaoExisteException {
        ArrayList<ItemPedido> itemPedidosCategoria = new ArrayList<>();
        try {
            for (ItemPedido itemPedido: itensPedidos
            ) {
                if (itemPedido.getProduto().getCategoriaProduto() == categoria){
                    itemPedidosCategoria.add(itemPedido);
                }

            }
        }catch (Error error){
            new CategoriaNaoExisteException();
        }

        return itemPedidosCategoria;
    }

    @Override
    public ItemPedido buscarItemPedido(Produto produto) throws ItemPedidoNaoCadastradoException {
        for (ItemPedido itemPedido :itensPedidos) {
            if (itemPedido.getProduto().getIdProduto() == produto.getIdProduto()){
                return itemPedido;
            }else throw new ItemPedidoNaoCadastradoException();

        }

        return null;
    }
}