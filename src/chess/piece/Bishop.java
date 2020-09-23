package chess.piece;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {


    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0,0);
        //Movimento Noroeste

        position.setValues(position.getRow() -1,position.getColumn()-1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() -1,position.getColumn() -1);
        }
        if(getBoard().positionExists(position) && isThereOpponentPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento Nordeste

        position.setValues(position.getRow()-1, position.getColumn()+1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getRow()] = true;
            position.setValues(position.getRow() -1,position.getColumn()+1);
        }
        if(getBoard().positionExists(position) && isThereOpponentPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento Suldeste.

        position.setValues(position.getRow()+1,position.getColumn() +1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow()+1,position.getColumn()+1);
        }
        if(getBoard().positionExists(position)&& !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento Suldoeste.

        position.setValues(position.getRow() + 1,position.getColumn()-1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow()+1,position.getColumn()-1);
        }
        if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        return matrix;
    }
}