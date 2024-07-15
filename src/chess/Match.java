package chess;

import board.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class Match {
  private Board board;

  public Match() {
    board = new Board(8, 8);
    initialSetup();
  }

  private void initialSetup() {
    placeNewPiece('a', 1, new Rook(board, Color.WHITE));
    placeNewPiece('d', 8, new King(board, Color.BLACK));
    placeNewPiece('d', 1, new King(board, Color.WHITE));
  }

  private void placeNewPiece(char column, int row, ChessPiece piece) {
    board.placePiece(piece, new ChessPosition(row, column).toPosition());
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
