package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ex51 {
    public static void main(String[] args) {

        List<ChessPiece> captured = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true){
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source:");
                ChessPosition source = UI.readChessPosition(scanner);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(),possibleMoves);

                System.out.println();
                System.out.print("Target:");
                ChessPosition target = UI.readChessPosition(scanner);


                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece!= null){
                    captured.add(capturedPiece);

                }
            }
            catch (ChessException chessException){
                System.out.print(chessException.getMessage());
                scanner.nextLine();
            }
            catch (InputMismatchException inputMismatchException){
                System.out.print(inputMismatchException.getMessage());
                scanner.nextLine();

            }
        }


    }


}
