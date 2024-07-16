package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Match;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Match match = new Match();
        List<ChessPiece> captured = new ArrayList<>(); //todo

        while (!match.isInCheckMate()) {
            try {
                UI.clearScream();
                UI.printMatch(match, captured);
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
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

            } catch (ChessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        UI.clearScream();
        UI.printMatch(match, captured);
    }
}
