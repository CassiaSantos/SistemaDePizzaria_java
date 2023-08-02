package repository.pedido;

import pattern.IdGeneratorStrategy;

import java.io.Serializable;

public class SequencialPedidoIdGeneratorStrategy implements IdGeneratorStrategy, Serializable {
    private int nextNumber;

    public SequencialPedidoIdGeneratorStrategy() {
        this.nextNumber = 1;
    }

    public String nextId() {
        return String.valueOf(nextNumber++);
    }
}
