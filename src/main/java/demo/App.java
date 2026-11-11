package demo;

/** Minimal app for the DevSecOps demo repo. */
public final class App {

  private App() {}

  /** Builds a greeting. */
  public static String greet(String name) {
    return "Hello, " + name;
  }

  public static void main(String[] args) {
    System.out.println(greet("world"));
  }
}
