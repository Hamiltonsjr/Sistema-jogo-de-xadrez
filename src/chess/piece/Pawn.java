package chess.piece;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {


    public Pawn(Board board, Color color) {
        super(board, color);
    }

    public boolean [][] possibleMoves(){
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0,0);

        if(getColor() == Color.WHITE){
            position.setValues(position.getRow()-1,position.getColumn());
            if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
                matrix[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(position.getRow()-2,position.getColumn());
            Position position1 = new Position(position.getRow() - 1,position.getColumn());
            if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)&& getBoard().positionExists(position1) && !getBoard().thereIsAPiece(position1) && getMoveCount() == 0){
                matrix[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(position.getRow()-1,position.getColumn() - 1);
            if(getBoard().positionExists(position) && isThereOpponentPiece(position)){
                matrix[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(position.getRow()-1,position.getColumn() + 1);
            if(getBoard().positionExists(position) && isThereOpponentPiece(position)){
                matrix[position.getRow()][position.getColumn()] = true;
            }

        }
        else {
            position.setValues(position.getRow()+1,position.getColumn());
            if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)){
                matrix[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(position.getRow()+2,position.getColumn());
            Position position1 = new Position(position.getRow() + 1,position.getColumn());
            if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)&& getBoard().positionExists(position1) && !getBoard().thereIsAPiece(position1) && getMoveCount() == 0){
                matrix[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(position.getRow()+1,position.getColumn() - 1);
            if(getBoard().positionExists(position) && isThereOpponentPiece(position)){
                matrix[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(position.getRow()+1,position.getColumn() + 1);
            if(getBoard().positionExists(position) && isThereOpponentPiece(position)){
                matrix[position.getRow()][position.getColumn()] = true;
            }

        }
        return matrix;
    }

    @Override
    public String toString() {
        return "P";
    }
}
