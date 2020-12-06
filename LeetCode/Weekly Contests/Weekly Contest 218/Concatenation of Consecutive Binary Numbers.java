class Solution {
	public final static int modValue = 1000000007;

	public int concatenatedBinary(int n) {
		return getDecimalValue(n);
	}

	private int getDecimalValue(int n) {
		int decimalValue = 0;
		int powerOf2 = 1;
		for (int i = n; i >= 1; i--) {
			int num = i;
			while (num > 0) {
				int digit = (num % 2);
				num /= 2;
				decimalValue = (decimalValue + (digit * powerOf2)) % modValue;
				powerOf2 = (powerOf2 * 2) % modValue;
			}
		}
		return decimalValue;
	}
}