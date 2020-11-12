package edu.studio.issue;

import kong.unirest.Unirest;

/*
 * Pass in one arg, which is your GitHub personal access token (PAT)
 * To run from command-line, use this command but replace <token> with your PAT: 
 * java -cp ghi-demo-0.0.1-SNAPSHOT-jar-with-dependencies.jar edu.studio.demo.UnirestDemo <token>
 */

public class UnirestDemo {
    
    protected static final String TEST_AREA_URL = 
            "https://api.github.com/repos/CSC5930-Fall2020-Org/github-issues-5930-f20-Pixeldrum/issues?state=all";
    
    public static void main(String[] args) {
        UnirestDemo demo = new UnirestDemo();
        
        demo.requestViaBearerToken(args);
    }
    
    protected void requestViaBearerToken(String[] args) {
        String responseBody = 
                Unirest.get(TEST_AREA_URL)
               .header("Authorization", "Bearer " + args[0])
               .asString()
               .getBody();
        
        System.out.println(responseBody);
    }

}

