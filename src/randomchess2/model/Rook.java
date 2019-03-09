package randomchess2.model;

/**
 * Represents a Rook in the RandomChess game.
 * More info to come...
 */
public final class Rook extends AbstractPiece {

  /**
   * Constructs a Rook piece.
   * Abstracts class checks validity of name and player fields.
   */
  private Rook(String id, String playerId) {
    super(id, playerId);
  }

  /**
   * Returns this piece's representation as a string.
   */
  public String toString() {
    return "R";
  }

  /**
   * Returns a builder for this Rook.
   */
  public static RookBuilder builder() {
    return new RookBuilder();
  }

  /**
   * Builder class for this Rook.
   */
  public static class RookBuilder extends PieceBuilder {

    /**
     * Builds a Rook with its configurations.
     */
    public Piece build() {
      if (this.id == null || this.playerId == null) {
        throw new IllegalArgumentException(
            "Given id/player id is null");
      }
      return new Rook(this.id, this.playerId);
    }
  }
}

