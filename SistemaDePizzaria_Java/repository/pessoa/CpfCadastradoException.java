package repository.pessoa;

public class CpfCadastradoException extends Exception {

  public CpfCadastradoException() {
    super("CPF já cadastrado!");
  }
}
