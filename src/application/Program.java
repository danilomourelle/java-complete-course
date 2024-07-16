package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Match;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Match match = new Match();

        while (true) {
            try {
                UI.clearScream();
                UI.printMatch(match);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(scanner);

                boolean[][] possibleMoves = match.possibleMoves(source);
                UI.clearScream();
                UI.printBoard(match.getPieces(), possibleMoves);

                System.out.println();
                System.err.print("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = match.performChessMove(source, target);

            } catch (ChessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
