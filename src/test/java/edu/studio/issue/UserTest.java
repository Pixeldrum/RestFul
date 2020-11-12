package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testProperties() {
		User user = new User();
		user.setId(3);
		assertEquals(3,user.getId());
		String login = "pixeldrum";
		user.setLogin(login);
		assertEquals("pixeldrum",user.getLogin());
		
	}
	@Test
	public void testEqualsReferenceEquality() {
		
		User user = new User();
		User user1 = user;
		assertTrue(user==user1);
	}
	@Test
	public void testEqualsValueEquality() {
		User user = new User();
		User user1 = new User();
		user.setId(42);
		user1.setId(42);
		
		assertEquals(user,user1);
		assertEquals(user1.hashCode(), user.hashCode());
	}
	
	@Test
	public void testEqualsSymmetric() {
		User user = new User();
		User user1 = new User();
		User user2 = new User();
		user.setId(42);
		user2.setId(42);
		user1.setId(42);
		//reflexive
		assertEquals(user,user);
		//symmetric
		assertEquals(user,user1);
		//transitive
		assertTrue(user2.equals(user1));
		assertTrue(user.equals(user2));
	}
	@Test
	public void testCompareTo() {
		User user = new User();
		User user1 = new User();
		user.setId(4);
		user1.setId(42);
		assertTrue(user.compareTo(user1)<0);
	}
	@Test
	public void testtoString() {
		User user = new User();
		user.setId(3);
		
		String login = "pixeldrum";
		user.setLogin(login);
		
		String expectedString = "User [login=pixeldrum, id=3]";
		assertEquals(expectedString,user.toString());
	
	
		
	}
}
