import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NumIndPair {
	int num;
	int ind;

	public NumIndPair(int num, int ind) {
		this.num = num;
		this.ind = ind;
	}
}

class NumIndCompare implements Comparator<NumIndPair> {

	@Override
	public int compare(NumIndPair o1, NumIndPair o2) {
		return o2.num - o1.num;
	}

}

class Solution {
	public int maxDistance(List<List<Integer>> arrays) {
		List<NumIndPair> numIndPairs = new ArrayList<>();
		for (int i = 0; i < arrays.size(); i++) {
			if (arrays.get(i).size() == 0)
				continue;
			int r = arrays.get(i).size() - 1;
			numIndPairs.add(new NumIndPair(arrays.get(i).get(r), i));
		}
		Collections.sort(numIndPairs, new NumIndCompare());
		int ans = 0;
		for (int i = 0; i < arrays.size(); i++) {
			if (arrays.get(i).size() == 0)
				continue;
			int leftNumber = arrays.get(i).get(0);
			if (numIndPairs.get(0).ind != i) {
				ans = Math.max(ans, Math.abs(leftNumber - numIndPairs.get(0).num));
			} else {
				ans = Math.max(ans, Math.abs(leftNumber - numIndPairs.get(1).num));
			}
		}
		return ans;
	}
}