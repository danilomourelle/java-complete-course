package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

  public Knight(Board board, Color color) {
    super(board, color);
  }

  private boolean canMove(Position position) {
    ChessPiece p = (ChessPiece) getBoard().pieceOnSpot(position);

    return p == null || p.getColor() != getColor();
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
    Position spotToCheck = new Position();

    // top-left
    spotToCheck.setValues(super.position.getRow() - 2, super.position.getColumn() - 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // top-right
    spotToCheck.setValues(super.position.getRow() - 2, super.position.getColumn() + 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // right-top
    spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn() + 2);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // right-bottom
    spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn() + 2);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // bottom-right
    spotToCheck.setValues(super.position.getRow() + 2, super.position.getColumn() + 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // bottom-left
    spotToCheck.setValues(super.position.getRow() + 2, super.position.getColumn() - 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // left-bottom
    spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn() - 2);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // left-top
    spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn() - 2);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    return matrix;
  }

  @Override
  public String toString() {
    return "N";
  }

}
