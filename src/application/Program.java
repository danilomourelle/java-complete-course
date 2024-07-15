package application;

import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Match;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Match match = new Match();

        while (true) {
            UI.printBoard(match.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(scanner);

            System.out.println();
            System.err.print("Target: ");
            ChessPosition target = UI.readChessPosition(scanner);

            ChessPiece capturedPiece = match.performChessMove(source, target);

        }

    }
}
