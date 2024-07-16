package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

  public Bishop(Board board, Color color) {
    super(board, color);
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
    Position spotToCheck = new Position();

    // top-right
    spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn() + 1);
    while (getBoard().positionExists(spotToCheck) && !getBoard().thereIsAPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      spotToCheck.setValues(spotToCheck.getRow() - 1, spotToCheck.getColumn() + 1);
    }
    if (getBoard().positionExists(spotToCheck) && super.isThereOpponentPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // top-left
    spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn() - 1);
    while (getBoard().positionExists(spotToCheck) && !getBoard().thereIsAPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      spotToCheck.setValues(spotToCheck.getRow() - 1, spotToCheck.getColumn() - 1);
    }
    if (getBoard().positionExists(spotToCheck) && super.isThereOpponentPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // bottom-right
    spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn() + 1);
    while (getBoard().positionExists(spotToCheck) && !getBoard().thereIsAPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      spotToCheck.setValues(spotToCheck.getRow() + 1, spotToCheck.getColumn() + 1);
    }
    if (getBoard().positionExists(spotToCheck) && super.isThereOpponentPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // left
    spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn() - 1);
    while (getBoard().positionExists(spotToCheck) && !getBoard().thereIsAPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      spotToCheck.setValues(spotToCheck.getRow() + 1, spotToCheck.getColumn() - 1);
    }
    if (getBoard().positionExists(spotToCheck) && super.isThereOpponentPiece(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    return matrix;
  }

  @Override
  public String toString() {
    return "B";
  }
}
