import java.sql.*;

public class SimpleCRUD {
    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "Shamanyu123@"
            );

            PreparedStatement create = c.prepareStatement("INSERT INTO sample(name) VALUES(?)");
            create.setString(1, "John");
            create.executeUpdate();

            Statement read = c.createStatement();
            ResultSet rs = read.executeQuery("SELECT * FROM sample");
            while (rs.next()) System.out.println(rs.getInt(1) + " " + rs.getString(2));

            PreparedStatement update = c.prepareStatement("UPDATE sample SET name=? WHERE id=?");
            update.setString(1, "Updated John");
            update.setInt(2, 1);
            update.executeUpdate();

            PreparedStatement delete = c.prepareStatement("DELETE FROM sample WHERE id=?");
            delete.setInt(1, 1);
            delete.executeUpdate();

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
