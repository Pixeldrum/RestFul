package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class IssueExporterTest {

	@Test
	void testexportIssues() {
		
		 IssueExporter exporter = new IssueExporter();
		 File file = new File("actual-issues.txt");
		 String token = System.getProperty("bearer.token");
		 String[] argument = {token};
		 exporter.exportIssues(exporter.getJson(exporter.IssueExporterTokenCheck(argument)));
		 assertTrue(file.exists());
		 
	}
	@Test
	void testIssueExporterTokenCheck() {
		String token = System.getProperty("bearer.token");
		 String[] argument = {token};
		 IssueExporter exporter = new IssueExporter();
		String actualToken = exporter.IssueExporterTokenCheck(argument);
		 assertEquals(token,actualToken);
		
	}
	@Test
	void testfileWrite() throws FileNotFoundException {
		 File file = new File("actual-issues.txt");
		 IssueExporter exporter = new IssueExporter();
		 String token = System.getProperty("bearer.token");
		 String[] argument = {token};
		 String expectedString = "Issue [id=732695505, createdAt=Thu Oct 29 22:05:25 EDT 2020, user=User [login=Pixeldrum, id=56083084], number=4, assignee=null, state=open, title=Commit, body=, closedAt=null]";
		 
		 List<Issue> Issues = exporter.getJson(exporter.IssueExporterTokenCheck(argument));
		 exporter.fileWrite(file, Issues);
		 Scanner f = null;
		 f = new Scanner(file);
		 String fileTemp = f.nextLine();
		assertEquals(fileTemp,expectedString);
	}
	@Test
	void testgetJson() {
		 IssueExporter exporter = new IssueExporter();
		 String token = System.getProperty("bearer.token");
		 String[] argument = {token};
		 List<Issue> Issues = exporter.getJson(exporter.IssueExporterTokenCheck(argument));
		assertTrue(!Issues.isEmpty());
		assertEquals(4,Issues.size());
		
	}

}
