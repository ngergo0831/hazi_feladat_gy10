package bar;

public class AgeGroupException extends Exception {
  private static final long serialVersionUID = 1L;

  public AgeGroupException(String errorMessage) {
    super(errorMessage);
  }
}