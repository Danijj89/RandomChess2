package randomchess2.model;

/**
 * Represents a factory to generate game pieces.
 * Need to add some connection stuff to retrieve all the pieces from db.
 */
public class PieceFactory {

  // The map of all the pieces that exists in the RandomChess game.
  // The key is the id of the each piece and the value is a supplier of the piece.
  private final HashMap<String, PieceBuilder> allPieces;
  // The list of default pieces that each player gets when first signing in.
  private final HashMap<String, Integer> defaultPieces;

  /**
   * Constructor with the map of all the pieces available in the game.
   */
  public PieceFactory() {
    this.allPieces = new HashMap<String, PieceBuilder>();
    this.allPieces.put("Rook", Rook.builder());
    this.allPieces.put("Empty", Empty.builder());

    this.defaultPieces = new HashMap<String, Integer>();
    this.defaultPieces.put("Rook", 16);
  }

  /**
   * Returns a copy of the default pieces.
   */
  public HashMap<String, Integer> getDefaultPieces() {
    return new HashMap<String, Integer>(this.defaultPieces);
  }

  /**
   * Builds a piece of the given id for the given player.
   */
  public Piece makePiece(String id, String playerId) {
    return this.allPieces.get(id).setId(id).setPlayerId(playerId).build();
  }
}
