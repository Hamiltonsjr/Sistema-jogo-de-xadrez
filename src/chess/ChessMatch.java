package chess;

import boardgame.Board;
import boardgame.Position;
import chess.piece.King;
import chess.piece.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat =  new ChessPiece[board.getRows()][board.getRows()];
        for(int i=0; i < board.getRows(); i++){
            for (int j=0; j <board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }
    private void placeNewPiece(char columns, int row, ChessPiece piece){
        board.placePiece(piece,new ChessPosition(columns,row).toPosition());

    }
    private void initialSetup(){
        placeNewPiece('b',6, new Rook(board,Color.WHITE));
        //board.placePiece(new King(board,Color.BLACK), new Position(0,4));
        //board.placePiece(new King(board,Color.WHITE), new Position(7,4));
    }
}
