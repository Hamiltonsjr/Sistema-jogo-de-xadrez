package chess.piece;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public abstract class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch ChessMatch) {
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

    private boolean testRookCastling(Position position){
        ChessPiece  p = (ChessPiece)getBoard().piece(position);
       return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() ==0;


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

        // specialMove castling

        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            // specialMove castling Kingside rook
            Position posT1 = new Position(position.getRow(),position.getColumn() + 3);
            if(testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(),position.getColumn() + 1);
                Position p2 = new Position(position.getRow(),position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    matrix[position.getRow()][position.getColumn()+2] = true;
                }
            }

            // specialMove castling queenside rook

            Position posT2 = new Position(position.getRow(),position.getColumn() -4);
            if(testRookCastling(posT2)){
                Position p1 = new Position(position.getRow(),position.getColumn() - 1);
                Position p2 = new Position(position.getRow(),position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    matrix[position.getRow()][position.getColumn()-2] = true;
                }
            }
        }


        return matrix;
    }


}
