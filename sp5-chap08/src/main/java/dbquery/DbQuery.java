package dbquery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DbQuery {
	private DataSource ds;

	public DbQuery() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public DbQuery(DataSource ds) {
		this.ds = ds;
	}

	public int count() {
		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM MEMBER");) {
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
