package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;
import chess.Match;

public class Pawn extends ChessPiece {

  private Match match;

  public Pawn(Board board, Color color, Match match) {
    super(board, color);
    this.match = match;
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
      Position pathToSpot = new Position(super.position.getRow() - 1, super.position.getColumn());
      if (getMoveCount() == 0
          && super.getBoard().positionExists(spotToCheck)
          && !super.getBoard().thereIsAPiece(spotToCheck)
          && !super.getBoard().thereIsAPiece(pathToSpot)) {
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

      // en passant
      if (position.getRow() == 3) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left) && isThereOpponentPiece(left)
            && getBoard().pieceOnSpot(left) == match.getEnPassantVulnerable()) {
          matrix[left.getRow() - 1][left.getColumn()] = true;
        }
        Position right = new Position(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(right) && isThereOpponentPiece(right)
            && getBoard().pieceOnSpot(right) == match.getEnPassantVulnerable()) {
          matrix[right.getRow() - 1][right.getColumn()] = true;
        }
      }
    } else {
      spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn());
      if (super.getBoard().positionExists(spotToCheck) && !super.getBoard().thereIsAPiece(spotToCheck)) {
        matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
      }

      spotToCheck.setValues(super.position.getRow() + 2, super.position.getColumn());
      Position pathToSpot = new Position(super.position.getRow() + 1, super.position.getColumn());
      if (getMoveCount() == 0
          && super.getBoard().positionExists(spotToCheck)
          && !super.getBoard().thereIsAPiece(spotToCheck)
          && !super.getBoard().thereIsAPiece(pathToSpot)) {
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

      // en passant
      if (position.getRow() == 4) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left) && isThereOpponentPiece(left)
            && getBoard().pieceOnSpot(left) == match.getEnPassantVulnerable()) {
          matrix[left.getRow() + 1][left.getColumn()] = true;
        }
        Position right = new Position(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(right) && isThereOpponentPiece(right)
            && getBoard().pieceOnSpot(right) == match.getEnPassantVulnerable()) {
          matrix[right.getRow() + 1][right.getColumn()] = true;
        }
      }
    }

    return matrix;
  }

  @Override
  public String toString() {
    return "P";
  }
}
