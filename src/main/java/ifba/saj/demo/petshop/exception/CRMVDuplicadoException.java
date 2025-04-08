package ifba.saj.demo.petshop.exception;

public class CRMVDuplicadoException extends RuntimeException {

  public CRMVDuplicadoException() {
    super("CRMV do veterinário já em uso.");
  }
}
