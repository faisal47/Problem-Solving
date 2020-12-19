package practice.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class BfsNode {
	String word;
	int dist;

	public BfsNode(String word, int dist) {
		this.word = word;
		this.dist = dist;
	}
}

class Solution {
	Map<String, Boolean> wordListMap;

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		return bfs(beginWord, endWord, wordList);
	}

	private int bfs(String beginWord, String endWord, List<String> wordList) {

		Queue<BfsNode> bfsQueue = new LinkedList<>();
		bfsQueue.add(new BfsNode(beginWord, 0));
		Map<String, Boolean> visitedNode = new HashMap<>();
		visitedNode.put(beginWord, true);

		while (!bfsQueue.isEmpty()) {

			BfsNode uNode = bfsQueue.poll();
			if (uNode.word.equals(endWord))
				return uNode.dist + 1;

			for (int i = 0; i < wordList.size(); i++) {
				String nowWord = wordList.get(i);

				if (wordDistance(uNode.word, nowWord) == 1 && !visitedNode.containsKey(nowWord)) {
					visitedNode.put(nowWord, true);
					bfsQueue.add(new BfsNode(nowWord, uNode.dist + 1));
				}
			}
		}
		return 0;
	}

	private int wordDistance(String word, String nowWord) {
		if (word.length() != nowWord.length())
			return 100;
		int distance = 0;
		for (int i = 0; i < word.length() && distance < 2; i++)
			if (word.charAt(i) != nowWord.charAt(i))
				distance++;
		return distance;
	}
}