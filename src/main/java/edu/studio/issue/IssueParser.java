package edu.studio.issue;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class IssueParser {
	
private Gson gson;

public IssueParser() {
	 gson = new GsonBuilder()
			 .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
			 .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			 .create();
}
	public List<Issue> parseJson(String json) {	
		List<Issue> issues = new ArrayList<Issue>();
		Type collectionType = new TypeToken<List<Issue>>(){}.getType();
		issues = gson.fromJson(json, collectionType);
		return issues;
	}

}
