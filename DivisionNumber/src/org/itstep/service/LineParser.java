package org.itstep.service;

public class LineParser {

	public StringBuffer getFinalText(int divide, int divisor) {
		StringBuffer finalText = new StringBuffer();
		StringBuffer headText = new StringBuffer();
		StringBuffer resultText = new StringBuffer();
		StringBuffer processingText = new StringBuffer();
		StringBuffer blankText = new StringBuffer();
		String periodNum = "";
		int result = 0;
		int nonIntRes = 0;
		int counter = 0;
		headText.append("_" + divide + " |_" + divisor + "__ \n " + getRatio(divide, divisor) + "    |");
		result = divide/divisor;
		while ((Integer.toString(divide).length()-1) - Integer.toString(divisor).length() > 0){
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
		if(Integer.toString(divide/divisor).length() == 2){
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
				nonIntRes = divide/divisor;
				periodNum = periodNum + nonIntRes;
				//resultText.append("" + nonIntRes);
				counter++;
			} while(divide%divisor != 0 && counter <= 9);
			resultText.append("" + getPeriodNum(periodNum));
		} else{
			resultText.append("" + result);
		}
		headText.append(resultText + "\n");
		finalText = finalText.append(headText).append(processingText);
		return finalText;
}
	
	public String getPeriodNum(String periodNum) {
		String period = "";
		char [] num = periodNum.toCharArray();
		for (int i = 1; i < 1; i++) {
			if (num[i-1] != num[i]){
				period = period + num[i];
			}
			else{
				//period = period +  "(" + num[i] + ")";
			}	
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
		return resedent; //возвращает число которое делится на делитель
	}
	
	public int getResidentialPast(int divide, int divisor){
		int resedentPast = 0;
		int i = 1;
			while (Integer.parseInt(Integer.toString(divide).substring(0, i))<divisor){
				i++;
			}
			resedentPast = Integer.parseInt(Integer.toString(divide).substring(i, Integer.toString(divide).length())); 
		return resedentPast; //возвращает число которое является остатком	
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
		return ratio; //возвращает значение результата умноженого на делитель
	}
}
