package manager;

public class Close {
    public static void Single(Object obj) {
        if (obj == null)
            return;
        try {
            if (obj instanceof java.sql.ResultSet)
                ((java.sql.ResultSet) obj).close();
            else if (obj instanceof java.sql.PreparedStatement)
                ((java.sql.PreparedStatement) obj).close();
            else if (obj instanceof java.sql.Statement)
                ((java.sql.Statement) obj).close();
            else if (obj instanceof java.sql.ResultSet)
                ((java.sql.ResultSet) obj).close();
        } catch (java.sql.SQLException e) {
 
        }
    }
}
