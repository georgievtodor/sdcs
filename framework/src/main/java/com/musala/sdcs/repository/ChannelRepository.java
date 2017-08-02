package com.musala.sdcs.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.musala.sdcs.db.DbUtil;
import com.musala.sdcs.device.channel.base.Channel;
import com.musala.sdcs.device.channel.base.ChannelCreator;

/**
 * Takes care of DB queries related to channels
 *
 */
@Repository
public class ChannelRepository {
	private static final String QUERY_UPDATE_COMMAND = "UPDATE channels SET command = '%s' WHERE id = %s;";
	private static final String QUERY_UPDATE_LABEL = "UPDATE channels SET label = '%s' WHERE id = %s;";
	private static final String QUERY_GET_CHANNEL = "SELECT command FROM channels WHERE id = %s;";
	private static final String CHANNEL_COMMAND = "command";

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
	 * @return command or fail message for front-end handling
	 * @throws SQLException
	 */
	public String updateChannelCommand(String command, Integer id, String channelType) throws SQLException {
		String query = String.format(QUERY_UPDATE_COMMAND, command, id);

		logger.info(query);

		try {
			CallableStatement stmt = dbConnection.prepareCall(query);

			stmt.executeUpdate();

			return command;

		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * updates current channel label
	 * 
	 * @param command
	 * @param id
	 * @return label or fail message for front-end handling
	 * @throws SQLException
	 */
	public String updateChannelLabel(String label, Integer id, String channelType) throws SQLException {
		String query = String.format(QUERY_UPDATE_LABEL, label, id);

		logger.info(query);

		try {
			CallableStatement stmt = dbConnection.prepareCall(query);

			stmt.executeUpdate();

			return label;

		} catch (SQLException e) {
			throw e;
		}
	}
	
	public String getChannelCommandValue(Integer channelId) {
		String query = String.format(QUERY_GET_CHANNEL, channelId);

		ResultSet r = executeQuery(query);

		try {
			if (r.next()) {
				String command = r.getString(CHANNEL_COMMAND);
				
				return command;
			}
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}

		return null;

	}
	
	/**
	 * @param query
	 * @return result of the performed query
	 */
	private ResultSet executeQuery(String query) {
		ResultSet result = null;

		logger.info(query);

		try {
			CallableStatement stmt = dbConnection.prepareCall(query);

			result = stmt.executeQuery();

		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}

		return result;
	}

}
