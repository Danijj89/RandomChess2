package randomchess2.model;

/**
 * Represents an abstract builder for the game pieces.
 */
public abstract class PieceBuilder {
  protected String id;
  protected String playerId;

  /**
   * Sets the id of the piece.
   */
  public PieceBuilder setId(String id) {
    if (id == null) {
      throw new IllegalArgumentException("Given id is null");
    }
    this.id = id;
    return this;
  }

  /**
   * Sets the player of the piece.
   */
  public PieceBuilder setPlayerId(String playerId) {
    if (playerId == null) {
      throw new IllegalArgumentException("Given player is null");
    }
    this.playerId = playerId;
    return this;
  }

  /**
   * Allows each piece to build himself.
   */
  public abstract Piece build();
}
