package practice.problems;

/**
 * // This is ArrayReader's API interface. // You should not implement it, or
 * speculate about its implementation interface ArrayReader { public int get(int
 * index) {} }
 */

class Solution {
	public int search(ArrayReader reader, int target) {
		for (int i = 0; i < 10004; i++)
			if (reader.get(i) == target)
				return i;
			else if (reader.get(i) > target)
				return -1;
		return -1;
	}
}