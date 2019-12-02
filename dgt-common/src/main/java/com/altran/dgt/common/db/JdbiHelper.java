/**
 *
 */
package com.altran.dgt.common.db;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

/**
 * @author ramon
 *
 */
public class JdbiHelper {

	private DBI dbi;

	public JdbiHelper(DataSource dataSource) {
		dbi = new DBI(dataSource);
	}

	public DBI getDBI() {
		return dbi;
	}

	/**
	 * Return a handle suitable for use in a transaction operation, i.e. with autoCommit = false.
	 */
	public Handle getHandle() {
		Handle handle = getDBI().open();
		return handle;
	}

	/**
	 * Return a handle suitable for use in a transaction operation, i.e. with autoCommit = false.
	 */
	public void closeHandle(Handle handle) {
		if (handle != null && !handle.isClosed()) {
			handle.close();
		}

	}
}
