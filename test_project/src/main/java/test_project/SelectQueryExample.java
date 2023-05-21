package test_project;

import java.sql.*;

public class SelectQueryExample {
	public static void main(String[]argv) {
		/* Retrieve DB authentication information */
		DatabaseAuthInformation db_info = new DatabaseAuthInformation();
		db_info.parse_auth_info("auth/mysql.auth");
		
		/* Prepare the URL for DB connection */
		String db_connection_url = String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC", db_info.getHost(),
		db_info.getPort(),
		db_info.getDatabase_name());
		
		/* Prepare the query statement */
		String query_string = "select id, value from TEST_TB where id>22";
		
		/* DB insertion process */
		try (Connection db_connection = DriverManager.getConnection(db_connection_url, db_info.getUsername(),
				db_info.getPassword());
				PreparedStatement db_statement = db_connection.prepareStatement(query_string)){
		
		/* Set the query statement */
		ResultSet result_set = db_statement.executeQuery(query_string);
		/* Send query and get the result */
		while(result_set.next()) {
			System.out.println("#" + result_set.getInt(1)+":" + result_set.getFloat(2));
		}
		
		}catch (SQLException e) {
		e.printStackTrace();
		}

	}
}
