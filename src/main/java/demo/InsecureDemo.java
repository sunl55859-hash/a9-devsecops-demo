package demo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Demo class: the insecure patterns from the first version, now fixed. */
public class InsecureDemo {

  /** Finds user ids by name with a parameterized query, so the input cannot change the SQL. */
  public List<String> findUser(Connection connection, String name) throws SQLException {
    List<String> ids = new ArrayList<>();
    try (PreparedStatement statement =
        connection.prepareStatement("SELECT id FROM users WHERE name = ?")) {
      statement.setString(1, name);
      try (ResultSet rows = statement.executeQuery()) {
        while (rows.next()) {
          ids.add(rows.getString("id"));
        }
      }
    }
    return ids;
  }

  /** Hashes the input with SHA-256 instead of the weak MD5. */
  public byte[] hash(String input) throws NoSuchAlgorithmException {
    return MessageDigest.getInstance("SHA-256").digest(input.getBytes(StandardCharsets.UTF_8));
  }
}