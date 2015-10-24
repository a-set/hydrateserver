package hydrateserver.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hydratewithfriends.utility.DatabaseConnection;

public class TestDBConnection {
	@Test
	public void test() {
		assertTrue(new DatabaseConnection().makeConnection());
	}
}
