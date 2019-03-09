package randomchess2.model;

/**
 * Represents an implementation of a Player.
 * Each player has a unique id. It stores all its available pieces
 * to choose from when building the chosenPieces list that the
 * player intends to use in the game.
 */
public final class PlayerImpl implements Player {

  private final String id;
  private final String name;
  private final int score;
  // Map of chosen pieces for the game where the key
  // is the id of the piece and the value is the number
  // of those pieces chosen
  private HashMap<String, Integer> chosenPieces;
  // The key is the id of the piece and the value is the total
  // number of these pieces that are available in the player's
  // inventory
  private HashMap<String, Integer> availablePieces;

  /**
   * Constructs a new Player given its id (must be unique), name, and
   * a factory to build its initial pieces
   */
  public PlayerImpl(String id, String name, HashMap<String, Integer> availablePieces) {
    this.id = id;
    this.name = name;
    this.score = 0;
    this.chosenPieces = new HashMap<String, Integer>();
    this.availablePieces = availablePieces;
  }

  /**
   * Returns the number of pieces chosen so far.
   */
  public int getNumChosenPieces() {
    int result = 0;
    Set<String> keys = this.chosenPieces.keySet();
    for (String key : keys) {
      result += this.chosenPieces.get(key);
    }
    return result;
  }

  /**
   * Returns a copy of the chosen pieces by this player.
   */
  public List<Piece> getChosenPieces() {
    List<Piece> result = new ArrayList<Piece>();
    this.chosenPieces.forEach((K,V) -> {
      PieceFactory pf = new PieceFactory();
      for (int i = 0; i < V; i++) {
        Piece p = pf.makePiece(K, this.id);
        result.add(p);
      }
    });
    return result;
  }

  /**
   * Adds a piece to the map of chosen pieces.
   */
  public void addChosenPiece(String id) {
    if (id == null) {
      throw new IllegalArgumentException("Given id is null");
    }
    if (!this.availablePieces.containsKey(id)) {
      throw new IllegalArgumentException("There is no such piece in your inventory");
    }
    if (this.chosenPieces.containsKey(id)
        && (this.chosenPieces.get(id) >= this.availablePieces.get(id))) {
      throw new IllegalArgumentException(
          "All available pieces of this kind have already been added");
    }
    int curr = this.chosenPieces.getOrDefault(id, 0);
    this.chosenPieces.put(id, curr + 1);
  }
  // method implementation to do...
}

