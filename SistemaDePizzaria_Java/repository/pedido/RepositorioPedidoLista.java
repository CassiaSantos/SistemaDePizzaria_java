package repository.pedido;

import model.pedido.Pedido;
import pattern.IdGeneratorStrategy;
import repository.pedido.SequencialPedidoIdGeneratorStrategy;

import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioPedidoLista implements RepositorioPedido,Serializable {
    ArrayList<Pedido> pedidos;
    IdGeneratorStrategy idGenerator;
    public RepositorioPedidoLista() {
        this.pedidos = new ArrayList<>();
        idGenerator = new SequencialPedidoIdGeneratorStrategy();

    }
    @Override
    public void criarPedido(Pedido pedido) throws PedidoCadastradoException {
			
         if (pedido.getNumeroPedido() == null)
         {
            pedido.setNumeroPedido(Long.valueOf(idGenerator.nextId()));
		}

			/*Long npedido = pedido.getNumeroPedido();
			if (npedido.toString() == null){
				pedido.setNumeroPedido(Long.valueOf(idGenerator.nextId()));				
			}*/

        try {
            while (buscarPedido(pedido.getNumeroPedido()) != null) {
                pedido.setNumeroPedido(Long.valueOf(idGenerator.nextId()));
            }
        } catch ( PedidoNaoCadastradoException e) {
            pedidos.add(pedido);
        }

        try {
            buscarPedido(pedido.getNumeroPedido());
            //throw new PedidoCadastradoException();
        } catch (final PedidoNaoCadastradoException ex) {
            pedidos.add(pedido);
        }
    }

    @Override
    public void alterarPedido(Pedido pedido) throws PedidoNaoCadastradoException {
    //Não é necessário alterar o pedido na memória
        buscarPedido(pedido.getNumeroPedido());
    }

    @Override
    public void deletarPedido(Pedido pedido) throws PedidoNaoCadastradoException {
        if (!pedidos.remove(pedido)) {
            throw new PedidoNaoCadastradoException();
        }
    }

    // @Override
    public Pedido buscarPedido(long numeroPedido) throws PedidoNaoCadastradoException {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        throw new PedidoNaoCadastradoException();
    }

    // @Override
    public ArrayList<Pedido> getAll() {
        return pedidos;
    }

    public ArrayList<Pedido> getAll(String cpf) {
        ArrayList<Pedido> lista = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getCpf().equals(cpf)) {
                lista.add(pedido);
            }
        }
        return lista;
    }

}
