package randomchess2.model;

/**
 * Represents an abstract class for pieces in the game.
 */
abstract class AbstractPiece implements Piece {
  protected final String id;
  protected final String playerId;
  protected boolean isSelected;
  protected boolean isHidden;

  /**
   * Abstract constructor for a game piece.
   * Checks for validity of name and player.
   */
  protected AbstractPiece(String id, String playerId) {
    if (id == null || playerId == null) {
      throw new IllegalArgumentException("Given name/player is null");
    }
    this.id = id;
    this.playerId = playerId;
    this.isSelected = false;
    this.isHidden = true;
  }

  public abstract String toString();

}
