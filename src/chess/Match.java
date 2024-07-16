package chess;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Piece;
import board.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class Match {
  private Board board;
  private Color currentPlayer;
  private Integer turn;

  private List<Piece> capturedPieces = new ArrayList<>();
  private List<Piece> onBoardPieces = new ArrayList<>();

  public Match() {
    board = new Board(8, 8);
    turn = 1;
    currentPlayer = Color.WHITE;
    initialSetup();
  }

  public Integer getTurn() {
    return turn;
  }

  public Color getCurrentPlayer() {
    return currentPlayer;
  }

  private void initialSetup() {
    placeNewPiece('c', 1, new Rook(board, Color.WHITE));
    placeNewPiece('c', 2, new Rook(board, Color.WHITE));
    placeNewPiece('d', 2, new Rook(board, Color.WHITE));
    placeNewPiece('e', 2, new Rook(board, Color.WHITE));
    placeNewPiece('e', 1, new Rook(board, Color.WHITE));
    placeNewPiece('d', 1, new King(board, Color.WHITE));

    placeNewPiece('c', 7, new Rook(board, Color.BLACK));
    placeNewPiece('c', 8, new Rook(board, Color.BLACK));
    placeNewPiece('d', 7, new Rook(board, Color.BLACK));
    placeNewPiece('e', 7, new Rook(board, Color.BLACK));
    placeNewPiece('e', 8, new Rook(board, Color.BLACK));
    placeNewPiece('d', 8, new King(board, Color.BLACK));
  }

  private void placeNewPiece(char column, int row, ChessPiece piece) {
    board.placePiece(piece, new ChessPosition(row, column).toPosition());
    onBoardPieces.add(piece);
  }

  public boolean[][] possibleMoves(ChessPosition sourcePosition) {
    Position position = sourcePosition.toPosition();
    validateOriginalPosition(position);
    return board.pieceOnSpot(position).possibleMoves();
  }

  public ChessPiece performChessMove(ChessPosition original, ChessPosition target) {
    Position originalPosition = original.toPosition();
    Position targetPosition = target.toPosition();

    validateOriginalPosition(originalPosition);
    validateTargetPosition(originalPosition, targetPosition);
    Piece capturedPiece = makeMove(originalPosition, targetPosition);

    nextTurn();

    return (ChessPiece) capturedPiece;
    
  }

  private void validateOriginalPosition(Position position) {
    if (!board.spotHasPiece(position)) {
      throw new ChessException("There is no piece on source position");
    }
    if (currentPlayer != ((ChessPiece) board.pieceOnSpot(position)).getColor()) {
      throw new ChessException("This is not a piece you can move");
    }
    if (!board.pieceOnSpot(position).isThereAnyPossibleMove()){
      throw new ChessException("There is no possible moves for the chosen piece");
    }
  }

  private void validateTargetPosition(Position source, Position target ) {
    if(!board.pieceOnSpot(source).possibleMove(target)){
        throw new ChessException("The chosen piece can't move to target position");
    }
  }

  private Piece makeMove(Position original, Position target) {
    Piece p = board.remoPiece(original);
    Piece capturedPiece = board.remoPiece(target);
    if (capturedPiece != null) {
      onBoardPieces.remove(capturedPiece);
      capturedPieces.add(capturedPiece);
    }
    board.placePiece(p, target);

    return capturedPiece;
  }

  public ChessPiece[][] getPieces() {
    ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];
    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        matrix[i][j] = (ChessPiece) board.pieceOnSpot(i, j);
      }
    }

    return matrix;
  }

  private void nextTurn() {
    turn++;
    currentPlayer = currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE;
  }
}
