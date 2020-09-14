package chess.piece;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0,0);

        //Movimento para cima

        position.setValues(position.getRow()-1,position.getColumn());
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() -1);
        }
        if(getBoard().positionExists(position) && isThereOpponentPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento para a esquerda.

        position.setValues(position.getRow(), position.getColumn()-1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getRow()] = true;
            position.setColumn(position.getColumn()-1);
        }
        if(getBoard().positionExists(position) && isThereOpponentPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento para a direita.

        position.setValues(position.getRow(),position.getColumn() +1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn()+1);
        }
        if(getBoard().positionExists(position)&& !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // Movimento para baixo.

        position.setValues(position.getRow() + 1,position.getColumn());
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow()+1);
        }
        if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
            matrix[position.getRow()][position.getColumn()] = true;
        }
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