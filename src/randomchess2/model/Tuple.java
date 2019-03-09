package randomchess2.model;

/**
 * Utility class that represents a tuple.
 */
public final class Tuple<T> {
  private final T val1;
  private final T val2;

  public Tuple(T val1, T val2) {
    this.val1 = val1;
    this.val2 = val2;
  }

  public T getVal1() {
    return this.val1;
  }

  public T getVal2() {
    return this.val2;
  }
}
