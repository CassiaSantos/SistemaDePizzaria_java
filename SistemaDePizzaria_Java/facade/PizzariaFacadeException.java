package facade;

public class PizzariaFacadeException extends Exception {

  public PizzariaFacadeException() {
    super("Error Pizzaria Facade!");
  }

  public PizzariaFacadeException(String message) {
    super(message);
  }

  public PizzariaFacadeException(String message, Throwable e) {
    super(message, e);
  }

  
}