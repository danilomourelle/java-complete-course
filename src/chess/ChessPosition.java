package chess;

import board.Position;

public class ChessPosition {
  private Integer row;
  private Character column;

  public ChessPosition(int row, char column) {
    if (row < 1 || row > 8 || column < 'a' || column > 'h') {
      throw new ChessException("Piece position should be between a1 to h8");
    }
    this.row = row;
    this.column = column;
  }

  public Integer getRow() {
    return row;
  }

  public Character getColumn() {
    return column;
  }

  protected Position toPosition() {
    int positionRow = 8 - this.row;
    int positionColumn = this.column - 'a';

    return new Position(positionRow, positionColumn);
  }

  public ChessPosition fromPosition(Position position) {
    int chessPositionRow = 8 - position.getRow();
    char chessPositionColumn = (char) ('a' + position.getColumn());

    return new ChessPosition(chessPositionRow, chessPositionColumn);
  }

  @Override
  public String toString(){
    return "" + column + row;
  }
}
