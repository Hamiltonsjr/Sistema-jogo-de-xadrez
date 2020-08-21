package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    // Somente classes do mesmo pacote e subclasses vão poder
    //ascessar o tabuleiro de uma peça.

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];

    }
    public boolean isThereAnyPossibleMoves(){
        boolean[][] matriz = possibleMoves();
        for(int i = 0; i<matriz.length; i++){
            for (int j = 0; j<matriz.length; i++){
                if(matriz[i][j]){
                    return true;

                }
            }

        }
        return false;
    }


    public void add(Piece capturedPiece) {
    }
}
