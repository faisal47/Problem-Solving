
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

	List<List<Integer>> ans;
	List<Integer> tempAns;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ans = new ArrayList<>();
		tempAns = new ArrayList<>();
		backTrack(candidates, target, 0);
		return ans;
	}

	private void backTrack(int[] candidates, int target, int ind) {
		if (target == 0) {
			List<Integer> tempAnsClone = tempAns.stream().collect(Collectors.toList());
			ans.add(tempAnsClone);
			return;
		}
		if (target < 0 || ind >= candidates.length)
			return;
		backTrack(candidates, target, ind + 1);
		if (target - candidates[ind] >= 0) {
			tempAns.add(candidates[ind]);
			backTrack(candidates, target - candidates[ind], ind);
			tempAns.remove(tempAns.size() - 1);
		}
	}
}