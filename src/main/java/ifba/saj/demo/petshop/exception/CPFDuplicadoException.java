package ifba.saj.demo.petshop.exception;

public class CPFDuplicadoException extends RuntimeException {

  public CPFDuplicadoException() {
    super("CPF já em uso.");
  }
}
