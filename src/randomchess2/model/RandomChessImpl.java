package randomchess2.model;

/**
 * Represents an implementation of the RandomChess game.
 * This implementation uses a double array of pieces to represent
 * the game board and a provides a builder to set the game up.
 */
public final class RandomChessImpl implements RandomChess {
  private final int width;
  private final int height;
  private final Player p1;
  private final Player p2;
  private final Piece[][] board;
  private int piecesLeftP1;
  private int piecesLeftP2;

  /**
   * Private constructor used by the builder.
   * No need to check for arguments as it comes from builder.
   */
  private RandomChessImpl(int width, int height, Player p1, Player p2,
      Piece[][] board, int piecesPerPlayer) {
    this.width = width;
    this.height = height;
    this.p1 = p1;
    this.p2 = p2;
    this.board = board;
    this.piecesLeftP1 = piecesPerPlayer;
    this.piecesLeftP2 = piecesPerPlayer;
  }

  /**
   * Prints the current state of the board.
   */
  public String getGameState() {
    StringJoiner result = new StringJoiner("\n");
    for (int row = 0; row < this.height; row++) {
      StringJoiner tempRow  = new StringJoiner(" ");
      for (int col = 0; col < this.width; col++) {
        tempRow.add(board[row][col].toString());
      }
      result.add(tempRow.toString());
    }
    return result.toString();
  }

  /**
   * Move a piece from a position to a position and executes
   * actions according to the situation (kill a piece, eat, simple move).
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    //...
  }

  /**
   * Reveals the identity of the piece at given position if hidden.
   */
  public void reveal(int row, int col) {
    //...
  }

  /**
   * Selects the piece at the given position or unselects it if already selected.
   */
  public void select(int row, int col) {
    //...
  }

  /**
   * Check whether the game is over.
   */
  public boolean isGameOver() {
    return this.
  }

  /**
   * Builder for constructing a game of RandomChessImpl.
   */
  public static Builder builder() { return new Builder();}

  /**
   * Builder class implementation.
   * Allows to configure the width and height of the game board,
   * to set the players and the number of pieces per player allowed
   * for this game.
   */
  public static final class Builder {
    private int width;
    private int height;
    private Player p1;
    private Player p2;
    private int piecesPerPlayer;

    /**
     * Construct a Builder with default parameters.
     */
    private Builder() {
      this.width = 8;
      this.height = 8;
      this.p1 = null;
      this.p2 = null;
      this.piecesPerPlayer = 16;
    }

    /**
     * Set the players of the game.
     */
    public Builder setPlayers(Player p1, Player p2) {
      if (p1 == null || p2 == null) {
        throw new IllegalArgumentException("Given player/s is null");
      }
      this.p1 = p1;
      this.p2 = p2;
      return this;
    }

    /**
     * Set the width and height of the game board.
     */
    public Builder setWidthHeight(int width, int height) {
      if (width < 1 || height < 1) {
        throw new IllegalArgumentException("Given width/height is less than 1");
      }
      this.width = width;
      this.height = height;
      return this;
    }

    /**
     * Sets the starting number of pieces for each player.
     */
    public Builder setPiecesPerPlayer(int n) {
      if (n < 1) {
        throw new IllegalArgumentException("Given number is less than 1");
      }
      this.piecesPerPlayer = n;
      return this;
    }

    /**
     * Builds the game with the set configuration.
     * Utilizes Fisher-Yates Shuffle algorithm to randomize
     * pieces position on the board.
     */
    public RandomChessImpl build() {
      if ((2 * this.piecesPerPlayer) > (this.width * this.height)) {
        throw new IllegalArgumentException(
            "Number of pieces are more than the tiles on the board ");
      }
      if (this.p1 == null || this.p2 == null) {
        throw new IllegalArgumentException(
            "No players set: Set players in order to build game");
      }
      if (this.p1.getNumChosenPieces() != this.piecesPerPlayer
          || this.p2.getNumChosenPieces() != this.piecesPerPlayer) {
        throw new IllegalArgumentException(
            "The number of pieces chosen by the players "
                + "do not match with the game configuration");
      }
      // Initialize the empty board
      Piece[][] board = new Piece[this.height][this.width];
      // list of the pieces chosen by the players
      List<Piece> pieces = new ArrayList<>();
      pieces.addAll(this.p1.getChosenPieces());
      pieces.addAll(this.p2.getChosenPieces());

      // Fisher-Yates Shuffle algorithm
      List<Tuple<Integer>> hat = new ArrayList<>();
      // Put all possible coordinates in the hat
      for (int row = 0; row < this.height; row++) {
        for (int col = 0; col < this.width; col++) {
          Tuple<Integer> t = new Tuple<Integer>(row, col);
          hat.add(t);
        }
      }
      Random r = new Random();
      int upperBound = hat.size();
      // Pick a random position and assign it to a piece
      // and swap the chosen position to the end of the list
      for (int i = 0; i < pieces.size(); i++) {
        int n = r.nextInt(upperBound);
        Tuple<Integer> pos = hat.get(n);
        board[pos.getVal1()][pos.getVal2()] = pieces.get(i);
        // Swap
        Tuple<Integer> temp = hat.set(upperBound - 1, hat.get(n));
        hat.set(n, temp);
        upperBound -= 1;
      }
      PieceFactory pf = new PieceFactory();
      for (int i = 0; i < upperBound; i++) {
        Tuple<Integer> pos = hat.get(i);
        // The "null" player id given to make empty pieces are not used
        // by the builder of Empty.
        board[pos.getVal1()][pos.getVal2()] = pf.makePiece("Empty", "null");
      }
      return new RandomChessImpl(this.width, this.height,
          this.p1, this.p2, board, this.piecesPerPlayer);
    }
  }
}
