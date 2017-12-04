package org.itstep;

import static org.junit.Assert.*;

import org.itstep.service.LineParser;
import org.junit.Test;

public class DivisionNumberTest {


	@Test
	public void testGetResidential() {
		int divide = 12345;
		int divisor = 2;
		LineParser resedent = new LineParser();
		int outInt = resedent.getResidential(divide, divisor);
		assertEquals(12, outInt);	
	}

	@Test
	public void testgetResedentialPast(){
		int divide = 12345;
		int divisor = 2;
		LineParser resedentPast = new LineParser();
		int outInt = resedentPast.getResidentialPast(divide, divisor);
		assertEquals(345, outInt);
	}
	
	@Test
	public void testgetRatio(){
		int divide = 345;
		int divisor = 2;
		LineParser ratio = new LineParser();
		int outInt = ratio.getRatio(divide, divisor);
		assertEquals(2, outInt);
	}
}
