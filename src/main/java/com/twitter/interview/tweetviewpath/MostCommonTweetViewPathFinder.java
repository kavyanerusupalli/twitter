package com.twitter.interview.tweetviewpath;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonTweetViewPathFinder {
	
	private Map<String,List<String>> map;
	private Path maxPath;
	private Integer maxPathOccurance;
	private Map<Integer,Integer> occurances;
	
	public MostCommonTweetViewPathFinder() {
		map = new HashMap<>();
		maxPath = null;
		maxPathOccurance =0;
		occurances = new HashMap<>();
	}

	public Path getMostTweetViewPath(InputStream basicInputStream) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(basicInputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				createPerUserVisitSequence(line);
			}
			for(Map.Entry<String, List<String>> userSequence : map.entrySet()) {
				createPaths(userSequence.getValue());
			}
			maxPath.setOccurance(maxPathOccurance);
			return maxPath;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	private void createPaths(List<String> value) {
		for(int i=0;i<value.size()-2;i++) {
			Path currentPath = new Path(value.get(i),value.get(i+1),value.get(i+2));
			if(!occurances.containsKey(currentPath.hashCode())) {
				occurances.put(currentPath.hashCode(), 0);
			}
			occurances.put(currentPath.hashCode(), occurances.get(currentPath.hashCode()) + 1);
			 if(maxPathOccurance < occurances.get(currentPath.hashCode())) {
				 maxPathOccurance = occurances.get(currentPath.hashCode());
				 maxPath = currentPath;
			 }
		}
	}

	private void createPerUserVisitSequence(String line) {
		String userId = line.split(",")[0];
		String tweetId = line.split(",")[1];
		
		try {
			if(!map.containsKey(userId)) {
				map.put(userId, new ArrayList<>());
			}
			map.get(userId).add(tweetId);
		} catch(NullPointerException e) {
			System.out.println(e);
			//TODO: catch other exceptions
		}
	}
}
