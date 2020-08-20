package chess.piece;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0,0);

        // Movimento a cima.

        position.setValues(position.getRow()-1,position.getColumn());
        if(getBoard().positionExists(position) && canMove(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento a baixo.

        position.setValues(position.getRow() +1,position.getColumn());
        if(getBoard().positionExists(position) && canMove(position)){
            matrix[position.getRow()][position.getRow()] = true;
        }

        // Movimento a esquerda.

        position.setValues(position.getRow(),position.getColumn() -1);
        if(getBoard().positionExists(position) && canMove(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento a direita.

        position.setValues(position.getRow(),position.getColumn() + 1);
        if(getBoard().positionExists(position) && canMove(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento Noroeste.

        position.setValues(position.getRow() -1,position.getColumn() -1);
        if(getBoard().positionExists(position) && canMove(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento Nordeste.

        position.setValues(position.getRow() -1,position.getColumn() +1);
        if(getBoard().positionExists(position) && canMove(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        //  Movimento Suldoeste.

        position.setValues(position.getRow() +1,position.getColumn() -1);
        if(getBoard().positionExists(position) && canMove(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento Suldeste.

        position.setValues(position.getRow() +1 ,position.getColumn()+1);
        if(getBoard().positionExists(position) && canMove(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        return matrix;
    }
}
