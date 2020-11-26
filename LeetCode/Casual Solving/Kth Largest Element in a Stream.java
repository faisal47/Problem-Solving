package practice.problems;

import java.util.PriorityQueue;

class KthLargest {
	PriorityQueue<Integer> pq;
	int k;

	public KthLargest(int k, int[] nums) {
		pq = new PriorityQueue<>((a, b) -> {
			return a - b;
		});
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
			if (pq.size() > k)
				pq.remove();
		}
		this.k = k;
	}

	public int add(int val) {
		pq.add(val);
		if (pq.size() > k)
			pq.remove();
		return pq.peek();
	}
}