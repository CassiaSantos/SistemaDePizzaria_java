package repository.produto;
//import java.lang;

public class CategoriaNaoExisteException extends Exception{
    public CategoriaNaoExisteException() {
        super("Categoria não Existe");
    }
}
