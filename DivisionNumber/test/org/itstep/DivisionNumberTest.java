package org.itstep;

import static org.junit.Assert.*;

import org.itstep.service.LineTransformat;
import org.junit.Test;

public class DivisionNumberTest {


	@Test
	public void testGetResidential() {
		int divide = 12345;
		int divisor = 2;
		LineTransformat resedent = new LineTransformat();
		int outInt = resedent.getResidential(divide, divisor);
		assertEquals(12, outInt);	
	}

	@Test
	public void testgetResedentialPast(){
		int divide = 12345;
		int divisor = 2;
		LineTransformat resedentPast = new LineTransformat();
		int outInt = resedentPast.getResidentialPast(divide, divisor);
		assertEquals(345, outInt);
	}
	
	@Test
	public void testgetRatio(){
		int divide = 345;
		int divisor = 2;
		LineTransformat ratio = new LineTransformat();
		int outInt = ratio.getRatio(divide, divisor);
		assertEquals(2, outInt);
	}
	
	@Test
	public void testgetPeriod(){
		int divisor = 1;
		String  excessNum = "1234333333";
		LineTransformat period = new LineTransformat();
		String outInt = period.getPeriod(excessNum, divisor);
		assertEquals("1234(3)", outInt);
	}
}
