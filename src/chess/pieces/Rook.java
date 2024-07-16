package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

  public Rook(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "R";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
    Position spotToCheck = new Position();

    // above
    spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn());
    while (getBoard().positionExists(spotToCheck) && !getBoard().thereIsAPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      spotToCheck.setValues(spotToCheck.getRow() - 1, spotToCheck.getColumn());
    }
    if (getBoard().positionExists(spotToCheck) && super.isThereOpponentPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // below
    spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn());
    while (getBoard().positionExists(spotToCheck) && !getBoard().thereIsAPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      spotToCheck.setValues(spotToCheck.getRow() + 1, spotToCheck.getColumn());
    }
    if (getBoard().positionExists(spotToCheck) && super.isThereOpponentPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // right
    spotToCheck.setValues(super.position.getRow(), super.position.getColumn() + 1);
    while (getBoard().positionExists(spotToCheck) && !getBoard().thereIsAPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      spotToCheck.setValues(spotToCheck.getRow(), spotToCheck.getColumn() + 1);
    }
    if (getBoard().positionExists(spotToCheck) && super.isThereOpponentPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // left
    spotToCheck.setValues(super.position.getRow(), super.position.getColumn() - 1);
    while (getBoard().positionExists(spotToCheck) && !getBoard().thereIsAPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      spotToCheck.setValues(spotToCheck.getRow(), spotToCheck.getColumn() - 1);
    }
    if (getBoard().positionExists(spotToCheck) && super.isThereOpponentPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    return matrix;
  }
}
