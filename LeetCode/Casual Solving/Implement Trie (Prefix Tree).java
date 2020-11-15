package practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieTree {
	int nodeNum;
	int[] nextNode = new int[26];
	boolean wordEnd;

	public TrieTree(int nodeNum) {
		this.nodeNum = nodeNum;
		Arrays.fill(nextNode, -1);
		wordEnd = false;
	}
}

class Trie {

	List<TrieTree> trieTrees;

	/** Initialize your data structure here. */
	public Trie() {
		trieTrees = new ArrayList<>();
		trieTrees.add(new TrieTree(0));
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		int nowNode = 0;
		for (int i = 0; i < word.length(); i++) {
			int nowChar = word.charAt(i) - 'a';
			TrieTree nowTree = trieTrees.get(nowNode);
			if (nowTree.nextNode[nowChar] == -1) {
				int newNodeVal = trieTrees.size();
				TrieTree newNode = new TrieTree(newNodeVal);
				nowTree.nextNode[nowChar] = newNodeVal;
				trieTrees.add(newNode);
				nowNode = newNodeVal;
			} else {
				nowNode = nowTree.nextNode[nowChar];
			}
		}
		trieTrees.get(nowNode).wordEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		int nowNode = 0;
		for (int i = 0; i < word.length(); i++) {
			int nowChar = word.charAt(i) - 'a';
			TrieTree nowTree = trieTrees.get(nowNode);
			if (nowTree.nextNode[nowChar] == -1) {
				return false;
			} else {
				nowNode = nowTree.nextNode[nowChar];
			}
		}
		return trieTrees.get(nowNode).wordEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		int nowNode = 0;
		for (int i = 0; i < prefix.length(); i++) {
			int nowChar = prefix.charAt(i) - 'a';
			TrieTree nowTree = trieTrees.get(nowNode);
			if (nowTree.nextNode[nowChar] == -1) {
				return false;
			} else {
				nowNode = nowTree.nextNode[nowChar];
			}
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */