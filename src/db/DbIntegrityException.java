package db;

public class DbIntegrityException extends RuntimeException { //excessão personalizada

    private static final long serialVersionUID = 1L;

    public DbIntegrityException(String msg) {
        super(msg);
    }
}
