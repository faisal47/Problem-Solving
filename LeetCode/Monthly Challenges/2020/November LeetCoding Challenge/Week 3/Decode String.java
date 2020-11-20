package practice.problems;

import java.util.Stack;

class Solution {
	public String decodeString(String s) {
		Stack<Integer> numberStack = new Stack<>();
		Stack<Character> charStack = new Stack<>();
		int index = 0;
		StringBuilder ansStringBuilder = new StringBuilder();
		while (index < s.length()) {
			if (s.charAt(index) == ']') {
				StringBuilder tempString = new StringBuilder();
				while (charStack.peek() != '[') {
					tempString.append(charStack.pop());
				}
				charStack.pop();
				tempString.reverse();
				int tempNumber = numberStack.pop();
				StringBuilder repeatString = new StringBuilder();
				while (tempNumber > 0) {
					tempNumber--;
					repeatString.append(tempString);
				}
				if (charStack.isEmpty()) {
					ansStringBuilder.append(repeatString);
				} else {
					for (int i = 0; i < repeatString.length(); i++) {
						charStack.add(repeatString.charAt(i));
					}
				}
				index++;
			} else {
				if (Character.isDigit(s.charAt(index))) {
					int num = 0;
					while (Character.isDigit(s.charAt(index))) {
						num = (num * 10) + (s.charAt(index++) - '0');
					}
					numberStack.add(num);
				} else {
					charStack.add(s.charAt(index++));
				}
			}
		}
		StringBuilder tempString = new StringBuilder();
		while (!charStack.isEmpty()) {
			tempString.append(charStack.pop());
		}
		ansStringBuilder.append(tempString.reverse());
		return ansStringBuilder.toString();
	}
}