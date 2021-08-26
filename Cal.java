package is.ru.stringCal;

public class Cal {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			String deli = ",";
			if(text.matches("//(.*)\n(.*)")){
				deli = Character.toString(text.charAt(2));
				text = text.substring(4);
			}
			
			String numList[] = splitnums(text, deli + "|\n");
			return sum(numList);
		}
	}

	private static int toInt(String num){
		return Integer.parseInt(num);
	}

	private static String[] splitnums(String nums, String div){
	    return nums.split(div);
	}

	private static int sum(String[] nums){
 	    int tot = 0;
 	    String negativestr = "";

        for(String num : nums){
        	if(toInt(num) < 0){
        		if(negativestr.equals(""))
        			negativestr = num;
        		else
        			negativestr += ("," + num);
        	}
        	if(toInt(num) < 1000)
		    	tot += toInt(num);
		}

		if(!negativestr.equals("")){
			throw new IllegalArgumentException("Negatives are not permitted: " + negativestr);
		}

		return tot;
    }
}