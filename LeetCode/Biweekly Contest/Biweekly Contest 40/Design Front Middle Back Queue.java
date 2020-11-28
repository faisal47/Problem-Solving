package practice.problems;

import java.util.ArrayList;
import java.util.List;

class FrontMiddleBackQueue {

	List<Integer> fmbQueue;

	public FrontMiddleBackQueue() {
		fmbQueue = new ArrayList<>();
	}

	public void pushFront(int val) {
		fmbQueue.add(0, val);
	}

	public void pushMiddle(int val) {
		int mid = fmbQueue.size() / 2;
		fmbQueue.add(mid, val);
	}

	public void pushBack(int val) {
		fmbQueue.add(val);
	}

	public int popFront() {
		if (fmbQueue.size() == 0)
			return -1;
		int retVal = fmbQueue.get(0);
		fmbQueue.remove(0);
		return retVal;
	}

	public int popMiddle() {
		if (fmbQueue.size() == 0)
			return -1;
		int index = fmbQueue.size() / 2;
		if (fmbQueue.size() % 2 == 0)
			index--;
		int retVal = fmbQueue.get(index);
		fmbQueue.remove(index);
		return retVal;
	}

	public int popBack() {
		if (fmbQueue.size() == 0)
			return -1;
		int index = fmbQueue.size() - 1;
		int retVal = fmbQueue.get(index);
		fmbQueue.remove(index);
		return retVal;
	}

}
