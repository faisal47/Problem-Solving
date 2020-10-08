
import java.util.Arrays;

class TwoSum {
	int numbersCount[] = new int[200010];

	public TwoSum() {
		Arrays.fill(numbersCount, 0);
	}

	public void add(int number) {
		number += 100000;
		numbersCount[number]++;
	}

	public boolean find(int value) {
		value += 200000;
		if (value > 400000 || value < 0)
			return false;
		int halfNumber = value / 2;
		for (int i = 0; i <= halfNumber; i++) {
			int a = i;
			int b = value - i;
			if (a == b && numbersCount[a] >= 2)
				return true;
			if (a != b && numbersCount[a] > 0 && numbersCount[b] > 0)
				return true;
		}
		return false;
	}
}