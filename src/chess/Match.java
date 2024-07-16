package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import board.Board;
import board.Piece;
import board.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class Match {
  private Board board;
  private Color currentPlayer;
  private Integer turn;
  private boolean isInCheck;
  private boolean isInCheckMate;

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

  public boolean isInCheck() {
    return isInCheck;
  }

  public boolean isInCheckMate() {
    return isInCheckMate;
  }

  private void initialSetup() {
    placeNewPiece('a', 1, new Rook(board, Color.WHITE));
    placeNewPiece('b', 1, new Knight(board, Color.WHITE));
    placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
    placeNewPiece('d', 1, new Queen(board, Color.WHITE));
    placeNewPiece('e', 1, new King(board, Color.WHITE));
    placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
    placeNewPiece('g', 1, new Knight(board, Color.WHITE));
    placeNewPiece('h', 1, new Rook(board, Color.WHITE));
    placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
    placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
    placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
    placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
    placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
    placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
    placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
    placeNewPiece('h', 2, new Pawn(board, Color.WHITE));
    
    placeNewPiece('a', 8, new Rook(board, Color.BLACK));
    placeNewPiece('b', 8, new Knight(board, Color.BLACK));
    placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
    placeNewPiece('d', 8, new Queen(board, Color.BLACK));
    placeNewPiece('e', 8, new King(board, Color.BLACK));
    placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
    placeNewPiece('g', 8, new Knight(board, Color.BLACK));
    placeNewPiece('h', 8, new Rook(board, Color.BLACK));
    placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
    placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
    placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
    placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
    placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
    placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
    placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
    placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
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

    if (testCheck(currentPlayer)) {
      undoMove(originalPosition, targetPosition, capturedPiece);
      throw new ChessException("You can't put yourself in a check position");
    }

    // todo
    this.isInCheck = (testCheck(opponent(currentPlayer))) ? true : false;

    if (testCheckMate(opponent(currentPlayer))) {
      isInCheckMate = true;
    } else {
      nextTurn();
    }

    return (ChessPiece) capturedPiece;

  }

  private void validateOriginalPosition(Position position) {
    if (!board.thereIsAPiece(position)) {
      throw new ChessException("There is no piece on source position");
    }
    if (currentPlayer != ((ChessPiece) board.pieceOnSpot(position)).getColor()) {
      throw new ChessException("This is not a piece you can move");
    }
    if (!board.pieceOnSpot(position).isThereAnyPossibleMove()) {
      throw new ChessException("There is no possible moves for the chosen piece");
    }
  }

  private void validateTargetPosition(Position source, Position target) {
    if (!board.pieceOnSpot(source).possibleMove(target)) {
      throw new ChessException("The chosen piece can't move to target position");
    }
  }

  private Piece makeMove(Position original, Position target) {
    ChessPiece p = (ChessPiece) board.remoPiece(original);

    Piece capturedPiece = board.remoPiece(target);
    if (capturedPiece != null) {
      onBoardPieces.remove(capturedPiece);
      capturedPieces.add(capturedPiece);
    }
    board.placePiece(p, target);

    p.increaseMoveCount();

    return capturedPiece;
  }

  private void undoMove(Position source, Position target, Piece capturedPiece) {
    ChessPiece p = (ChessPiece) board.remoPiece(target);
    board.placePiece(p, source);

    p.decreaseMoveCount();

    if (capturedPiece != null) {
      board.placePiece(capturedPiece, target);
      capturedPieces.remove(capturedPiece);
      onBoardPieces.add(capturedPiece);
    }
  }

  private Color opponent(Color color) {
    return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
  }

  // todo
  private ChessPiece king(Color color) {
    List<Piece> list = onBoardPieces
        .stream()
        .filter(p -> ((ChessPiece) p).getColor() == color)
        .collect(Collectors.toList());

    for (Piece piece : list) {
      if (piece instanceof King) {
        return (ChessPiece) piece;
      }
    }

    throw new IllegalStateException("There is no " + color + " king on the board");
  }

  // todo
  private boolean testCheck(Color color) {
    Position kingPosition = king(color).getChessPosition().toPosition();
    List<Piece> opponentsPieces = onBoardPieces
        .stream()
        .filter(p -> ((ChessPiece) p).getColor() == opponent(color))
        .collect(Collectors.toList());

    for (Piece piece : opponentsPieces) {
      boolean[][] matrix = piece.possibleMoves();
      if (matrix[kingPosition.getRow()][kingPosition.getColumn()]) {
        return true;
      }
    }

    return false;
  }

  private boolean testCheckMate(Color color) {
    if (!testCheck(color)) {
      return false;
    }

    List<Piece> list = onBoardPieces
        .stream()
        .filter(p -> ((ChessPiece) p).getColor() == color)
        .collect(Collectors.toList());

    for (Piece piece : list) {
      boolean[][] matrix = piece.possibleMoves();
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j]) {
            Position source = ((ChessPiece) piece).getChessPosition().toPosition();
            Position target = new Position(i, j);
            Piece capturedPiece = makeMove(source, target);
            boolean keptInCheck = testCheck(color);
            undoMove(source, target, capturedPiece);
            if (!keptInCheck) {
              return false;
            }
          }
        }
      }
    }

    return true;
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
    currentPlayer = currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE; // todo
  }
}
