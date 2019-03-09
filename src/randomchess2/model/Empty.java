package randomchess2.model;

/**
 * Represents an empty tile.
 */
public final class Empty implements Piece {
  private final String id;
  /**
   * The construction of this class has to go through
   * its builder.
   */
  private Empty(String id) {
    if (id == null) {
      throw new IllegalArgumentException("Given id is null");
    }
    this.id = id;
  }

  /**
   * Returns this piece's representation as a string.
   */
  public String toString() {
    return "_";
  }

  /**
   * Returns a builder for this Empty.
   */
  public static EmptyBuilder builder() {
    return new EmptyBuilder();
  }

  /**
   * Builder class for this Empty.
   */
  public static class EmptyBuilder extends PieceBuilder {
    /**
     * Builds an Empty with its configuration.
     * Ignores its player id field as this Empty has
     * no player field.
     */
    public Piece build() {
      if (this.id == null) {
        throw new IllegalArgumentException("Given id is null");
      }
      return new Empty(this.id);
    }
  }
}
