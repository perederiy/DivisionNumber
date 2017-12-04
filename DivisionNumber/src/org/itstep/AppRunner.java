package org.itstep;

import org.itstep.pojo.DefenitionVariable;
import org.itstep.service.LineParser;

public class AppRunner {

	public static void main(String[] args) {
		DefenitionVariable variable = new DefenitionVariable(12345,7);
		
		LineParser parser = new LineParser();
		StringBuffer finalText = parser.getFinalText(variable.getDivide(), variable.getDivisor());
		
		System.out.println(finalText);
	}
}
