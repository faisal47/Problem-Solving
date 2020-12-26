package com.java.practice;

import java.util.ArrayList;
import java.util.List;

class LetterLog {
	String indentiFier;
	String letters;
	String originalLog;

	LetterLog(String indentiFier, String letters, String originalLog) {
		this.indentiFier = indentiFier;
		this.letters = letters;
		this.originalLog = originalLog;
	}
}

class Solution {
	List<String> digitLogs;
	List<LetterLog> letterLogs;

	public String[] reorderLogFiles(String[] logs) {
		pre();
		for (int i = 0; i < logs.length; i++) {
			String log = logs[i];
			if (isDigitLog(log)) {
				digitLogs.add(log);
				continue;
			}
			String indentifier = getIdentifier(log);
			String letters = getLetters(log);
			letterLogs.add(new LetterLog(indentifier, letters, log));
		}
		letterLogs.sort((a, b) -> {
			if (a.letters.equals(b.letters)) {
				return a.indentiFier.compareTo(b.indentiFier);
			}
			return a.letters.compareTo(b.letters);
		});

		int ind = 0;
		for (int i = 0; i < letterLogs.size(); i++)
			logs[ind++] = letterLogs.get(i).originalLog;
		for (int i = 0; i < digitLogs.size(); i++)
			logs[ind++] = digitLogs.get(i);
		return logs;
	}

	private String getLetters(String log) {
		StringBuilder lettersStringBuilder = new StringBuilder();
		boolean spaceFound = false;
		for (int i = 0; i < log.length(); i++) {
			if (log.charAt(i) == ' ' && !spaceFound) {
				spaceFound = true;
				continue;
			}
			if (spaceFound)
				lettersStringBuilder.append(log.charAt(i));
		}
		return lettersStringBuilder.toString();
	}

	private String getIdentifier(String log) {
		StringBuilder indentifierStringBuilder = new StringBuilder();
		for (int i = 0; i < log.length(); i++)
			if (log.charAt(i) == ' ')
				return indentifierStringBuilder.toString();
			else
				indentifierStringBuilder.append(log.charAt(i));
		return null;
	}

	private boolean isDigitLog(String log) {

		boolean spaceFound = false;
		for (int i = 0; i < log.length(); i++) {
			spaceFound |= log.charAt(i) == ' ';
			if (log.charAt(i) != ' ' && spaceFound)
				return Character.isDigit(log.charAt(i));
		}
		return false;
	}

	private void pre() {
		digitLogs = new ArrayList<>();
		letterLogs = new ArrayList<>();
	}
}