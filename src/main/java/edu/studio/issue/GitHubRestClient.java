package edu.studio.issue;

import kong.unirest.Unirest;

public class GitHubRestClient {
	protected static final String TEST_AREA_URL = 
            "https://api.github.com/repos/CSC5930-Fall2020-Org/github-issues-5930-f20-Pixeldrum/issues?state=all";
    
	public String getIssuesFromGitHub(String token) {
		 String responseBody = 
	                Unirest.get(TEST_AREA_URL)
	               .header("Authorization", "Bearer " + token)
	               .asString()
	               .getBody();
		return responseBody;
	}
	
	public int getStatusFromGitHub(String token) {
		 int responseBody = 
	                Unirest.get(TEST_AREA_URL)
	               .header("Authorization", "Bearer " + token)
	               .asString()
	               .getStatus()
	               ;
	               
		 			
	               
		return responseBody;
	}


}
