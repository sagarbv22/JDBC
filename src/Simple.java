import java.sql.*;

public class Simple {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			// load & register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded sucessfully.");

			// establish the connection with DB
			String url = "jdbc:mysql:///people";
			String userName = "root";
			String passWord = "Sagar@123";

			connection = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connection is established");

			// Create a Statement Object and execute the Query
			statement = connection.createStatement();
			String selectQuery = "select id, firstName, lastName,profession, city from friends";
			resultSet = statement.executeQuery(selectQuery);

			// Process the ResultSet
			while (resultSet.next()) {

				System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("firstName") + "\t"
						+ resultSet.getString("lastname") + "\t" + resultSet.getString("profession") + "\t"
						+ resultSet.getString("city"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();
		}

		// close the resource
		finally {

			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
