package board;

public class Board {
  private Integer rows;
  private Integer columns;
  private Piece[][] spots;

  public Board(int rows, int columns) {
    if (rows < 1 || columns < 1) {
      throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
    }
    this.rows = rows;
    this.columns = columns;

    spots = new Piece[rows][columns];
  }

  public Integer getRows() {
    return rows;
  }

  public Integer getColumns() {
    return columns;
  }

  public Piece pieceOnSpot(int row, int column) {
    if (!positionExists(row, column)) {
      throw new BoardException("Position not on the board");
    }
    return spots[row][column];
  }

  public Piece pieceOnSpot(Position position) {
    if (!positionExists(position)) {
      throw new BoardException("Position not on the board");
    }
    return spots[position.getRow()][position.getColumn()];
  }

  // todo - return a piece if it is captured. This should have position check?
  public void placePiece(Piece piece, Position position) {
    if (thereIsAPiece(position)) {
      throw new BoardException("This spot already has a piece");
    }

    spots[position.getRow()][position.getColumn()] = piece;
    piece.position = position;
  }

  public Piece remoPiece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException("Position not on the Board");
    }

    Piece pieceToRemove = pieceOnSpot(position);
    if (pieceToRemove == null) {
      return null;
    }

    pieceToRemove.position = null;
    spots[position.getRow()][position.getColumn()] = null;

    return pieceToRemove;
  }

  private boolean positionExists(int row, int column) {
    boolean rowExists = row >= 0 && row < rows;
    boolean columnExists = column >= 0 && column < columns;

    return rowExists && columnExists;
  }

  public boolean positionExists(Position position) {
    return positionExists(position.getRow(), position.getColumn());
  }

  // todo
  public boolean thereIsAPiece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException("Position not on the board");
    }
    return pieceOnSpot(position) != null;
  }
}
