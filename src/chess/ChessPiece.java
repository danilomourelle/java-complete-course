package chess;

import board.Board;
import board.Piece;
import board.Position;

public abstract class ChessPiece extends Piece {
  private Color color;
  private Integer moveCount;

  public ChessPiece(Board board, Color color){
    super(board);
    this.color = color;
    this.moveCount = 0;
  }

  public Color getColor() {
    return color;
  }

  public void increaseMoveCount() {
    moveCount++;
  }

  public void decreaseMoveCount() {
    moveCount--;
  }

  public ChessPosition getChessPosition() {
    return ChessPosition.fromPosition(super.position);
  }

  protected boolean isThereOpponentPiece(Position position){
    ChessPiece p = (ChessPiece) getBoard().pieceOnSpot(position);
    return p != null && p.getColor() != color;
  }
}
