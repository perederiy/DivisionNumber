package org.itstep;

import org.itstep.pojo.DefenitionVariable;
import org.itstep.service.LineTransformat;

public class AppRunner {

	public static void main(String[] args) {
		DefenitionVariable variable = new DefenitionVariable(12345,103);
		
		LineTransformat transformat = new LineTransformat();
		StringBuffer finalText = transformat.getFinalText(variable.getDivide(), variable.getDivisor());
		
		System.out.println(finalText);
	}
}
