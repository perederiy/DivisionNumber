package org.itstep.service;

public class LineTransformat {

	public StringBuffer getFinalText(int divide, int divisor) {
		StringBuffer finalText = new StringBuffer();
		StringBuffer headText = new StringBuffer();
		StringBuffer resultText = new StringBuffer();
		StringBuffer processingText = new StringBuffer();
		StringBuffer blankText = new StringBuffer();
		String excessNum = "";
		int result = 0;
		int excess = 0;
		int counter = 0;
		headText.append("_" + divide + " |_" + divisor + "__ \n " + getRatio(divide, divisor) + "    |");
		result = divide/divisor;
		while (((Integer.toString(divide).length()-1) - Integer.toString(divisor).length() > 0) || (Integer.toString(divide/divisor).length() == 2)){
			if ((getResidential(divide, divisor) - getRatio(divide, divisor)) != 0){
				divide = Integer.parseInt(Integer.toString(getResidential(divide, divisor) 
						- getRatio(divide, divisor)) + Integer.toString(getResidentialPast(divide, divisor)));
				blankText.append(" ");
				processingText.append("" + blankText + "_" + getResidential(divide, divisor) + "\n " 
				+ blankText + getRatio(divide, divisor) + "\n");
			} else {
				divide = getResidentialPast(divide, divisor);
				blankText.append("  ");
				processingText.append("" + blankText + "_" + getResidential(divide, divisor) + "\n " 
				+ blankText + getRatio(divide, divisor) + "\n");
			}
		}
		processingText.append(" " + blankText + (getResidential(divide, divisor) - getRatio(divide, divisor)));
		if ((getResidential(divide, divisor) - getRatio(divide, divisor)) != 0){
			resultText.append("" + result + ",");
			do{
				divide = (getResidential(divide, divisor) - getRatio(divide, divisor))*10;
				excess = divide/divisor;
				excessNum = excessNum + excess;
				counter++;
			} while(divide%divisor != 0 && counter <= 9);
			resultText.append("" + getPeriod(excessNum, divisor));
		} else{
			resultText.append("" + result);
		}
		headText.append(resultText + "\n");
		finalText = finalText.append(headText).append(processingText);
		return finalText;
}
	
	public String getPeriod(String excessNum, int divisor) {
		int periodValue = Integer.toString(divisor).length();
		String period = "";
		int value = 0;
		char[] num = excessNum.toCharArray();
		if (periodValue == 1){
			for (int i= 0; i < (excessNum.length()-1); i++){
				if (Character.getNumericValue(num[i]) != Character.getNumericValue(num[i+1])){
					period = period + Character.getNumericValue(num[i]);
				}else{
					value =Character.getNumericValue(num[i]);
				}
			}
			if (value != 0){
				period =period + "(" + value + ")";
			} else {
				period = excessNum;
			}
		}
			
			if (periodValue == 2){
				for(int i = 0; i<((excessNum.length()-1)/2); i++){
					if((Character.getNumericValue(num[i]) * 10 + Character.getNumericValue(num[i+1])) !=
							(Character.getNumericValue(num[i+2]) * 10 + Character.getNumericValue(num[i+3]))){
						period = period + Character.getNumericValue(num[i]) + Character.getNumericValue(num[i+1]);
					} else {
						value =Character.getNumericValue(num[i]) * 10 + Character.getNumericValue(num[i+1]);
					}
					i = i + 3;
				if (value != 0){
					period = period + "(" + value + ")";
				} else {
					period = excessNum;
				}
			}
				if (excessNum.length()<10){
					period = excessNum;
				}
		}
			if (periodValue == 3){
				period = excessNum;
			}
		return period; 	
	}

	public int getResidential(int divide, int divisor){
		int resedent = 0;
		int i = 1;
			while (Integer.parseInt(Integer.toString(divide).substring(0, i))<divisor){
				i++;
			}
		resedent = Integer.parseInt(Integer.toString(divide).substring(0, i)); 
		return resedent; 
	}
	
	public int getResidentialPast(int divide, int divisor){
		int resedentPast = 0;
		int i = 1;
			while (Integer.parseInt(Integer.toString(divide).substring(0, i))<divisor){
				i++;
			}
			resedentPast = Integer.parseInt(Integer.toString(divide).substring(i, Integer.toString(divide).length())); 
		return resedentPast; 	
	}
	
	public int getRatio(int divide, int divisor){
		int resedent = 0;
		int ratio = 0;
		int result = 0;
		int i = 1;
			while (Integer.parseInt(Integer.toString(divide).substring(0, i))<divisor){
				i++;
			}
		resedent = Integer.parseInt(Integer.toString(divide).substring(0, i));
		result = resedent/divisor;
		ratio  = result*divisor;
		return ratio; 
	}
}
