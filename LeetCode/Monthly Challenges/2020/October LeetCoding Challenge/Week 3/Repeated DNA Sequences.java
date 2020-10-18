package practice.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ansList = new ArrayList<>();
		if (s.length() < 10)
			return ansList;
		StringBuilder st = new StringBuilder(s.substring(0, 9));
		Map<String, Integer> strCount = new HashMap<>();
		for (int i = 9; i < s.length(); i++) {
			st.append(s.charAt(i));
			if (strCount.containsKey(st.toString()))
				strCount.put(st.toString(), strCount.get(st.toString()) + 1);
			else
				strCount.put(st.toString(), 1);
			st.deleteCharAt(0);
		}
		for (Entry<String, Integer> str : strCount.entrySet())
			if (str.getValue() > 1)
				ansList.add(str.getKey());

		return ansList;
	}
}