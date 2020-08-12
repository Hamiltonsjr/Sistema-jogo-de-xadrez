package boardgame;
// Runtime execeção personaliada

public class BoardException extends RuntimeException{
    private static final long serialVersion = 1l;

    public BoardException(String msg){
        super(msg);
    }

}
