package demo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 只給 demo repo 用的「故意有問題」的程式，用來讓 SpotBugs/Find Security Bugs
 * 和 CodeQL 有東西可以回報，然後再修掉並重新掃描。不要放進你真正的專案。
 */
public class InsecureDemo {

  // 假密碼，僅供示範（不要放任何真的 secret）
  private static final String DB_PASSWORD = "not-a-real-password";

  /** 字串串接 SQL：典型的 SQL injection。 */
  public ResultSet findUser(Connection connection, String name) throws SQLException {
    Statement statement = connection.createStatement();
    return statement.executeQuery("SELECT * FROM users WHERE name = '" + name + "'");
  }

  /** MD5 是弱雜湊，不該用在密碼。 */
  public byte[] weakHash(String input) throws NoSuchAlgorithmException {
    return MessageDigest.getInstance("MD5").digest(input.getBytes(StandardCharsets.UTF_8));
  }

  public String password() {
    return DB_PASSWORD;
  }
}
