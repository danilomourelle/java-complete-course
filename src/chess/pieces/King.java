package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;
import chess.Match;

public class King extends ChessPiece {

  private Match match;

  public King(Board board, Color color, Match match) {
    super(board, color);
    this.match = match;
  }

  @Override
  public String toString() {
    return "K";
  }

  private boolean canMove(Position position) {
    ChessPiece p = (ChessPiece) getBoard().pieceOnSpot(position);

    return p == null || p.getColor() != getColor();
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
    Position spotToCheck = new Position();

    // top
    spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn());
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // bottom
    spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn());
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // right
    spotToCheck.setValues(super.position.getRow(), super.position.getColumn() - 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // left
    spotToCheck.setValues(super.position.getRow(), super.position.getColumn() + 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // top-left
    spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn() - 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // top-right
    spotToCheck.setValues(super.position.getRow() - 1, super.position.getColumn() + 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // bottom-left
    spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn() - 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // bottom-right
    spotToCheck.setValues(super.position.getRow() + 1, super.position.getColumn() + 1);
    if (getBoard().positionExists(spotToCheck) && canMove(spotToCheck)) {
      matrix[spotToCheck.getRow()][spotToCheck.getColumn()] = true;
    }

    // castling
    if (super.getMoveCount() == 0 && !match.isInCheck()) {
      // king-side
      // todo - possibleRook - interPosition
      Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
      if (testRookCastling(posT1)) {
        Position p1 = new Position(position.getRow(), position.getColumn() + 1);
        Position p2 = new Position(position.getRow(), position.getColumn() + 2);
        if (super.getBoard().pieceOnSpot(p1) == null
            && super.getBoard().pieceOnSpot(p2) == null) {
          matrix[position.getRow()][position.getColumn() + 2] = true;
        }
      }
      // queen-side
      // todo
      Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
      if (testRookCastling(posT2)) {
        Position p1 = new Position(position.getRow(), position.getColumn() - 1);
        Position p2 = new Position(position.getRow(), position.getColumn() - 2);
        Position p3 = new Position(position.getRow(), position.getColumn() - 3);
        if (super.getBoard().pieceOnSpot(p1) == null
            && super.getBoard().pieceOnSpot(p2) == null
            && super.getBoard().pieceOnSpot(p3) == null) {
          matrix[position.getRow()][position.getColumn() - 2] = true;
        }
      }
    }

    return matrix;
  }

  private boolean testRookCastling(Position position) {
    ChessPiece p = (ChessPiece) super.getBoard().pieceOnSpot(position);

    return p != null && p instanceof Rook && p.getColor() == this.getColor() && p.getMoveCount() == 0;
  }
}
