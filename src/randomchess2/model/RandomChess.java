package randomchess2.model;

/**
 * An interface for the RandomChess game.
 */
public interface RandomChess {

  /**
   * Move a piece from a position to a position and executes
   * actions according to the situation (kill a piece, eat, simple move).
   */
  void move(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * Reveals the identity of the piece at given position if hidden.
   */
  void reveal(int row, int col);

  /**
   * Selects the piece at the given position or unselects it if already selected.
   */
  void select(int row, int col);

  /**
   * Check whether the game is over.
   */
  boolean isGameOver();

  /**
   * Prints the current game state.
   * Utility method for debugging.
   */
  String getGameState();
}
