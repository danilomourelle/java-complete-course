package board;

public class Board {
  private Integer rows;
  private Integer columns;
  private Piece[][] spots;

  public Board(int rows, int columns){
    this.rows = rows;
    this.columns = columns;

    spots = new Piece[rows][columns];
  }

  public Integer getRows() {
    return rows;
  }

  public void setRows(Integer rows) {
    this.rows = rows;
  }

  public Integer getColumns() {
    return columns;
  }

  public void setColumns(Integer columns) {
    this.columns = columns;
  }

  public Piece pieceOnSpot(int row, int column) {
    return spots[row][column];
  }
  
  public Piece pieceOnSpot(Position position){
    return spots[position.getRow()][position.getColumn()];
  }

  public void placePiece(Piece piece, Position position){
    spots[position.getRow()][position.getColumn()] = piece;
    piece.position = position;
  }
}
