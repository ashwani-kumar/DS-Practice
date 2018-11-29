
public class Permutation {

//	static void permute(char[] str, int l, int r)
//	  {
//	      if (l != r)
//	      {
//	          for (int i = l; i <= r; i++)
//	          {
//	              str = swap(str,l,i);
//	              permute(str, l+1, r);
//	              str = swap(str,l,i);
//	          }
//	      }
//	      
//	  }
//    private static char[] swap(char[] str, int l, int i) {
//		// TODO Auto-generated method stub
//    	char a = str[l];
//    	char temp = a;
//    	str[l] = str[i];
//    	str[i] = temp;
//    	for (int j = 0; j <= str.length; j++) {
//	    	  System.out.println(str[j]);
//	    }
//		return str;
//	}
	
	private static void permute(String str, int l, int r)
	   {
	       if (l == r)
	           System.out.println(str);
	       else
	       {
	           for (int i = l; i <= r; i++)
	           {
	               str = swap(str,l,i);
	               permute(str, l+1, r);
	               str = swap(str,l,i);
	              // System.out.println(str);
	           }
	       }
	   }
    
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
	public static void main(String[] args){
		Permutation.permute("abc", 0, 2);
    }
}
