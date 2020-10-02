
import java.util.ArrayList;
import java.util.List;

class RecentCounter {
	List<Integer> times;

	public RecentCounter() {
		times = new ArrayList<>();
	}

	public int ping(int t) {
		times.add(t);
		return binarySearch(t - 3000);
	}

	private int binarySearch(int leftRange) {
		int l = 0;
		int r = times.size() - 1;
		int leftMostIndex = r;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (times.get(mid) < leftRange) {
				l = mid + 1;
			} else {
				leftMostIndex = mid;
				r = mid - 1;
			}
		}
		// System.out.println(leftRange + " " + leftMostIndex);
		return times.size() - leftMostIndex;
	}
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter(); int param_1 = obj.ping(t);
 */