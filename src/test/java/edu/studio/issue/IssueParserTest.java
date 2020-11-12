package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class IssueParserTest {

	@Test
	void testParseIssueWithValidJson() throws IOException {
		IssueParser parser = new IssueParser();
		String json = Files.readString(
				Paths.get("src/test/resources/testarea.json"));
		List<Issue> issues = parser.parseJson(json);
		assertNotNull(issues);
		assertEquals(4,issues.size());
	}

}
