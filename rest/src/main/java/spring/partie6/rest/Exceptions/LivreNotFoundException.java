package spring.partie6.rest.Exceptions;

public class LivreNotFoundException  extends  RuntimeException{
    public LivreNotFoundException(String message) {
        super(message);
    }
}
