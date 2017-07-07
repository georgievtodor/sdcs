package com.musala.sdcs.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.sdcs.db.DbUtil;

/**
 * Takes care of DB queries related to channels
 *
 */
public class ChannelRepository {
	private static final String QUERY_UPDATE_COMMAND = "UPDATE channels SET command = '%s' WHERE id = %s;";
	private static final String LOGGER_INVALID_SQL_MESSAGE = "Invalid sql query given";

	private Connection dbConnection;
	private Logger logger;

	public ChannelRepository() {
		this.dbConnection = DbUtil.getConnection();
		this.logger = LoggerFactory.getLogger(ChannelRepository.class);
	}

	/**
	 * updates current channel command
	 * 
	 * @param command
	 * @param id
	 */
	public void updateChannelCommand(String command, Integer id) {
		String query = String.format(QUERY_UPDATE_COMMAND, command, id);
		try {
			CallableStatement stmt = dbConnection.prepareCall(query);
			stmt.executeUpdate();

		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}

	}
}
