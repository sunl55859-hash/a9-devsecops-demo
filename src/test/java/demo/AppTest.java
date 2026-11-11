package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppTest {

  @Test
  void greetsByName() {
    assertEquals("Hello, DevSecOps", App.greet("DevSecOps"));
  }
}
