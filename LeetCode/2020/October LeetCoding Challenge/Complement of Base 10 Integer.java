class Solution {
	public int bitwiseComplement(int N) {
		if (N == 0)
			return 1;
		int ans = 0;
		int bitCountFromLeft = 0;
		while (N > 0) {
			int nowBit = N & 1;
			// System.out.println(nowBit + " " + (1 ^ nowBit));
			ans |= ((1 ^ nowBit) << bitCountFromLeft);
			N >>= 1;
			bitCountFromLeft++;
		}
		return ans;
	}
}