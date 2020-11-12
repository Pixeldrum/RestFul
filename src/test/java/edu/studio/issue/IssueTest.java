package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;

public class IssueTest {

	@Test
public void testProperties() {
		 Issue issue = new Issue();
	        
	        issue.setId(42);
	        assertEquals(42, issue.getId());
	        
	        Date expectedDate = new Date();
	        issue.setCreatedAt(expectedDate);
	        assertEquals(expectedDate, issue.getCreatedAt());
	        
	        User user = new User();
	        issue.setUser(user);
	        assertEquals(user, issue.getUser());
	        
	        User assigned = new User();
	        issue.setAssignee(assigned);
	        assertEquals(assigned,issue.getAssignee());
	        
	        issue.setNumber(3);
	        assertEquals(3,issue.getNumber());
	        
	        issue.setClosedAt(expectedDate);
	        assertEquals(expectedDate,issue.getClosedAt());
	        
	        String expectedBody = "test";
	        issue.setBody(expectedBody);
	        assertEquals(expectedBody,issue.getBody());
	        String state = "open";
	        issue.setState(state);
	        assertEquals(state,issue.getState());
	        String expectedTitle = "title";
	        issue.setTitle(expectedTitle);
	        assertEquals(expectedTitle,issue.getTitle());
	}

@Test

public void testEqualsReferenceEquality() {
	
	Issue issue1 = new Issue();
	Issue issue2 = issue1;
	assertTrue(issue1==issue2);
}

@Test
public void testEqualsValueEquality() {
	Issue issue1 = new Issue();
	Issue issue2 = new Issue();
	issue1.setId(42);
	issue2.setId(42);
	assertEquals(issue1,issue2);
	
	assertEquals(issue1.hashCode(), issue2.hashCode());
}

@Test
public void testEqualsSymmetric() {
	Issue issue1 = new Issue();
	Issue issue2 = new Issue();
	Issue issue3 = new Issue();
	issue1.setId(42);
	issue2.setId(42);
	issue3.setId(42);
	//reflexive
	assertEquals(issue1,issue1);
	//symmetric
	assertEquals(issue1,issue2);
	//transitive
	assertTrue(issue3.equals(issue2));
	assertTrue(issue1.equals(issue2));
}
@Test
public void testCompareTo() {
	Issue issue1 = new Issue();
	Issue issue2 = new Issue();
	issue1.setId(3);
	issue2.setId(4);
	assertTrue(issue1.compareTo(issue2)<0);
}

@Test
public void testtoString() {
	Issue issue = new Issue();
	 issue.setId(42);
    
     
     
     User user = new User();
     issue.setUser(user);
   
     
     User assigned = new User();
     issue.setAssignee(assigned);
   
     
     issue.setNumber(3);

     
  
     String expectedTitle = "title";
     issue.setTitle(expectedTitle);
     String expectedBody = "test";
     issue.setBody(expectedBody);
   
     String state = "open";
     issue.setState(state);
  System.out.println(issue);
     String expectedtoString = "Issue [id=42, createdAt=null, user=User [login=null, id=0], number=3, assignee=User [login=null, id=0], state=open, title=title, body=test, closedAt=null]";
     
    		assertEquals(expectedtoString,issue.toString());
}
}



