import java.io.FileReader;
import java.io.IOException;

public class ReadCV {
       public static void main(String args[]) throws IOException {
        FileReader fr = null;
        StringBuilder[] arrNum = new StringBuilder[10];
        StringBuilder[] arrletters = new StringBuilder[26];
        initArray(arrNum, arrletters);

        try {
             fr = new FileReader("C:\\Users\\ashwanikumar\\Downloads\\CV_Kumar_Ashwani_Text.txt");

               int c;
               int index;
               while ((c = fr.read()) != -1) {
                      c = Character.toLowerCase(c);
                      StringBuilder sb=null;
                      if(isNumeric(c)) {
                            index = c - '0';
                            sb = arrNum[index];
                            sb.append("-");
                      } else if(isLetter(c)) {
                          index = c - 'a';
                          sb = arrletters[index];
                          sb.append("-");
                      }
               }
               for(int i=0; i<arrNum.length; i++) {
                      char ch = (char) ('0' + i);
                      System.out.println(ch +" : "+ arrNum[i].toString());
               }

               for(int i = 0; i < arrletters.length; i++) {
               char ch = (char) ('a' + i);
                   System.out.println(ch +" : "+ arrletters[i].toString());
               }
        } finally {
               if (fr != null) {
               fr.close();
               }
        }
  }
       private static void initArray(StringBuilder[] arrNum, StringBuilder[] arrletters) {
           for(int i=0; i<arrNum.length; i++){
                  arrNum[i] = new StringBuilder();
           }
           
           for(int i=0; i<arrletters.length; i++){
                  arrletters[i] = new StringBuilder();
           }
           
     }

     private static boolean isNumeric(int c) {
           if(c>=48 && c <58) {
                  return true;
           }
           return false;
     }

     private static boolean isLetter(int c) {
           if(c>=97 && c<123) {
                  return true;
           }
           return false;
     }

}

