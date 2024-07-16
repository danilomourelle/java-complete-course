package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

  public Pawn(Board board, Color color) {
    super(board, color);
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] matrix = new boolean[super.getBoard().getRows()][super.getBoard().getColumns()];
    Position spotToCheck = new Position();

    // white
    if (getColor() == Color.WHITE) {
      spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn());
      if (super.getBoard().positionExists(spotToCheck) && !super.getBoard().thereIsAPiece(spotToCheck)) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }

      spotToCheck.setValues(super.position.getRow() - 2, super.position.getColumn());
      Position p2 = new Position(super.position.getRow() - 1, super.position.getColumn());
      if (super.getBoard().positionExists(spotToCheck)
          && !super.getBoard().thereIsAPiece(spotToCheck)
          && super.getBoard().positionExists(p2) // todo
          && !super.getBoard().thereIsAPiece(p2)
          && getMoveCount() == 0) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }

      spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn() - 1);
      if (super.getBoard().positionExists(spotToCheck) && isThereOpponentPiece(spotToCheck)) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }

      spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn() + 1);
      if (super.getBoard().positionExists(spotToCheck) && isThereOpponentPiece(spotToCheck)) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }
    } else {
      spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn());
      if (super.getBoard().positionExists(spotToCheck) && !super.getBoard().thereIsAPiece(spotToCheck)) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }

      spotToCheck.setValues(super.position.getRow() + 2, super.position.getColumn());
      Position p2 = new Position(super.position.getRow() + 1, super.position.getColumn());
      if (super.getBoard().positionExists(spotToCheck)
          && !super.getBoard().thereIsAPiece(spotToCheck)
          && super.getBoard().positionExists(p2) // todo
          && !super.getBoard().thereIsAPiece(p2)
          && getMoveCount() == 0) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }

      spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn() - 1);
      if (super.getBoard().positionExists(spotToCheck) && isThereOpponentPiece(spotToCheck)) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }

      spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn() + 1);
      if (super.getBoard().positionExists(spotToCheck) && isThereOpponentPiece(spotToCheck)) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }
    }

    return matrix;
  }

  @Override
  public String toString() {
    return "P";
  }
}
