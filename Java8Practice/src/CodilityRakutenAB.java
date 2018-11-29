
public class CodilityRakutenAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CodilityRakutenAB codilityRakutenAB = new CodilityRakutenAB();
		System.out.println(codilityRakutenAB.solution(1,5));
	}
	
	public String solution(int A, int B) {

	    String strLarge;
	    String strSmall;
	    
	    int countLarge; 
	    int countSmall;
	    
	    StringBuilder result = new StringBuilder();

	    if (A >= B) {
	        strLarge = "a";
	        strSmall = "b";
	        countLarge = A;
	        countSmall = B;
	    } else {
	        strLarge = "b";
	        strSmall = "a";
	        countLarge = B;
	        countSmall = A;
	    }

//	    if (countLarge > 2 * countSmall + 2) {
//	        return "Can't Find String";
//	    }

	    while(true) {
	        if (countLarge == countSmall + 1) {
	            result.append(strLarge);
	            countLarge--;
	        } else if (countLarge == countSmall) {
	            result.append(strLarge);
	            countLarge--;

	            result.append(strSmall);
	            countSmall--;
	        } else {
	            result.append(strLarge);
	            result.append(strLarge);
	            countLarge -= 2;

	            if (countSmall > 0) {
	                result.append(strSmall);
	                countSmall -= 1;
	            }
	        }
	        if(countLarge <= 0) {
	    		break;
	        }
	    }
//	    } while(countLarge > 0);

	    return result.toString();

	}

}
