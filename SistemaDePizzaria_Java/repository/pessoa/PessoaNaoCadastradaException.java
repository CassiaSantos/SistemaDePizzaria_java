package repository.pessoa;

public class PessoaNaoCadastradaException extends Exception {
  public PessoaNaoCadastradaException() {
    super("Pessoa não cadastrada!");
  }
}
