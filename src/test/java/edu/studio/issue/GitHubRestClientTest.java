package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class GitHubRestClientTest {

	@Test
	void testGetIssuesFromGitHub() throws IOException {
		GitHubRestClient client = new GitHubRestClient();
		String token = System.getProperty("bearer.token");
		String expectedJson = Files.readString(
				Paths.get("src/test/resources/testarea.json"));
		String actualJson = client.getIssuesFromGitHub(token);
		assertEquals(expectedJson, actualJson);
			}
@Test
	void testStatus() {
		GitHubRestClient client = new GitHubRestClient();
		String token = System.getProperty("bearer.token");
		int actualStatus = client.getStatusFromGitHub(token);
		int expectedStatus = 200;
		assertEquals(expectedStatus,actualStatus);
	}
}

