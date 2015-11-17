package hydrateserver.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hydratewithfriends.utility.DatabaseConnection;

public class TestDBInsertion {

	@Test
	public void test() {
		DatabaseConnection dbConn = new DatabaseConnection();
		dbConn.makeConnection();
		assertTrue(dbConn.insertInto(46l,100l, System.currentTimeMillis()));
	}

}
