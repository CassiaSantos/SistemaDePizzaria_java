package repository.produto;

import pattern.IdGeneratorStrategy;

import java.io.Serializable;

public class SequencialProdutoIdGeneratorStrategy implements IdGeneratorStrategy, Serializable {
    private long nextNumber;

    public SequencialProdutoIdGeneratorStrategy() {
        this.nextNumber = 1;
    }

    public String nextId() {
        return String.valueOf(nextNumber++);
    }
}
