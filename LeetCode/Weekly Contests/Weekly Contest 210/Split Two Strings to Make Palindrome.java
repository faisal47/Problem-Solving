package practice.problems;

class Solution {
	public boolean checkPalindromeFormation(String a, String b) {
		return isPalindrome(a) || isPalindrome(b) || leftFlip(a, b) || rightFlip(a, b) || leftFlip(b, a)
				|| rightFlip(b, a);
	}

	private boolean rightFlip(String a, String b) {
		int l = 0;
		int r = a.length() - 1;
		boolean rightFlipDone = false;
		while (l < r) {
			if (rightFlipDone) {
				if (a.charAt(l) != a.charAt(r))
					return false;
			} else {
				if (a.charAt(l) != b.charAt(r)) {
					rightFlipDone = true;
					l--;
					r++;
				}
			}
			l++;
			r--;
		}
		return true;
	}

	private boolean leftFlip(String a, String b) {
		int l = 0;
		int r = a.length() - 1;
		boolean leftFlipDone = false;
		while (l < r) {
			if (leftFlipDone) {
				if (b.charAt(l) != b.charAt(r))
					return false;
			} else {
				if (a.charAt(l) != b.charAt(r)) {
					leftFlipDone = true;
					l--;
					r++;
				}
			}
			l++;
			r--;
		}
		return true;
	}

	private boolean isPalindrome(String arr) {
		int l = 0;
		int r = arr.length() - 1;
		while (l < r) {
			if (arr.charAt(l) != arr.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}