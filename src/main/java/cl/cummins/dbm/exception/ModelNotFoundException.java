package cl.cummins.dbm.exception;

public class ModelNotFoundException  extends RuntimeException{
    public ModelNotFoundException(String mensaje){
        super(mensaje);
    }
}
