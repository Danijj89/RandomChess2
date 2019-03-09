package randomchess2.model;

/**
 * Represents an interface for the Player class.
 */
public interface Player {

  int getNumChosenPieces();

  List<Piece> getChosenPieces();

  void addChosenPiece(String id);

  // more methods to do...
}
