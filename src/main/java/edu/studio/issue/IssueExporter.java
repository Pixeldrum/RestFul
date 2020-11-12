package edu.studio.issue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IssueExporter {
	protected static final String OUTPUT_NAME="actual-issues.txt";
	
	GitHubRestClient client = new GitHubRestClient();
	IssueParser parser = new IssueParser();
	
	protected List<Issue> getJson(String token) {
		String json = client.getIssuesFromGitHub(token);
		List<Issue> Issues = parser.parseJson(json);
		return Issues;
	}
	
	 protected String IssueExporterTokenCheck(String[] args) {
		 String[] argument = args;
		 if(argument.length==0 || argument[0].equals("")) {
			 System.out.println("null or empty String, exiting");
			 System.exit(0);
		 } 
		
		 return argument[0];
	    
	 }
	 protected void exportIssues(List<Issue> issues) {
		
		 Collections.sort(issues);
		 File file = new File(OUTPUT_NAME);
		try {	
			if (file.createNewFile()) {
				fileWrite(file,issues);

			} else {

				fileWrite(file,issues);

			}
		}catch (IOException Exception) {
			System.out.println("IOException");
		}
	 }
	protected void fileWrite(File file, List<Issue> issuesSorted) {
		PrintWriter writer = null;
		try {
		writer = new PrintWriter(file);
		for(Issue issue: issuesSorted) {
			writer.println(issue.toString());
		}
		}catch(FileNotFoundException Exception){
			System.out.println("File not found");
		}finally {
			writer.close();
		}
	}

	public static void main(String[] args)  {
		IssueExporter exporter = new IssueExporter();
		exporter.exportIssues(exporter.getJson(exporter.IssueExporterTokenCheck(args)));
	}
}
