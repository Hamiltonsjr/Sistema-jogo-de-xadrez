package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex51 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true){
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch);
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
