package repository.pessoa;

import pattern.IdGeneratorStrategy;

import java.io.Serializable;

public class SequencialPessoaIdGeneratorStrategy implements IdGeneratorStrategy, Serializable {
    private int nextNumber;

    public SequencialPessoaIdGeneratorStrategy() {
        this.nextNumber = 1;
    }

    public String nextId() {
        return String.valueOf(nextNumber++);
    }
}
