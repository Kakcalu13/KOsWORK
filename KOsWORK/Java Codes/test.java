import java.util.*;

public class test {
        
   
    public static void main(String[] args) {
      int number=0;
      number |= 0x18;
      System.out.println(number);
      number<<=3;
      //byte b = (byte) 16;
      System.out.println("number <<: " + (number<<=3));
}
}
