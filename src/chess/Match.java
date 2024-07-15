package chess;

import board.Board;

public class Match {
  private Board board;

  public Match() {
    board = new Board(8, 8);
  }

  public ChessPiece[][] getPieces() {
    ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];
    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        matrix[i][j] = (ChessPiece) board.piece(i, j);
      }
    }

    return matrix;
  }
}
