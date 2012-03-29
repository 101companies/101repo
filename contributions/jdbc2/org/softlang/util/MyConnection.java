package org.softlang.util;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * The MyConnection-Class wraps a Connection and a MysqlDataSource-Object.
 */
public class MyConnection {

	private MysqlDataSource ds;
	private Connection conn;
	private Boolean isConnected;

	/**
	 * Constructs a new MyConnection-Object from the given access-data of the
	 * database.
	 * 
	 * @param server
	 *            The server's address.
	 * @param db
	 *            The database schema.
	 * @param port
	 *            The port.
	 * @param user
	 *            The username.
	 * @param pw
	 *            The user's password.
	 */
	public MyConnection(String server, String db, Integer port, String user,
			String pw) {

		this.ds = new MysqlDataSource();
		this.ds.setServerName(server);
		this.ds.setDatabaseName(db);
		this.ds.setUser(user);
		this.ds.setPassword(pw);
		this.isConnected = false;

	}

	/**
	 * Establishes a connection to the database.
	 * 
	 * @return True if connection was established successfully and false
	 *         otherwise.
	 */
	public Boolean connect() {

		try {
			this.conn = ds.getConnection();
		} catch (SQLException e) {
			System.err.println(e);
			this.isConnected = false;
			return false;
		}

		this.isConnected = true;
		return true;

	}

	/**
	 * Closes a connection to the database.
	 * 
	 * @return True if the connection was successfully closed and false
	 *         otherwise.
	 */
	public Boolean close() {

		if (this.isConnected) {

			try {
				this.conn.close();
			} catch (SQLException e) {
				System.err.println(e);
				this.isConnected = false;
				return false;
			}
		}

		this.isConnected = false;
		return true;

	}

	public MysqlDataSource getDs() {
		return ds;
	}

	public void setDs(MysqlDataSource ds) {
		this.ds = ds;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Boolean getIsConnected() {
		return isConnected;
	}
}
