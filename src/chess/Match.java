package chess;

import board.Board;
import board.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class Match {
  private Board board;

  public Match() {
    board = new Board(8, 8);
    initialSetup();
  }

  private void initialSetup() {
    board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
    board.placePiece(new King(board, Color.BLACK), new Position(0,4));
    board.placePiece(new King(board, Color.WHITE), new Position(7,4));
  }

  public ChessPiece[][] getPieces() {
    ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];
    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        matrix[i][j] = (ChessPiece) board.pieceOnSpot(i, j);
      }
    }

    return matrix;
  }
}
