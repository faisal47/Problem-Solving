
class Solution {
	public String interpret(String command) {
		StringBuilder goalAns = new StringBuilder();
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'G')
				goalAns.append('G');
			else if (command.charAt(i + 1) == ')') {
				goalAns.append('o');
				i += 1;
			} else {
				goalAns.append("al");
				i += 3;
			}
		}
		return goalAns.toString();
	}
}