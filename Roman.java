public class Roman {
    private int num;        
       private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,  
                                             50,   40,   10,    9,    5,    4,    1 };                                          
       private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
                                           "L",  "XL",  "X",  "IX", "V",  "IV", "I" };                                       
            
       public Roman(String roman)
         {             
          roman = roman.toUpperCase();            
          int i = 0;       
        int decimal = 0; 
              
       while (i < roman.length()) 
       {          
             char letter = roman.charAt(i);        
             int number = letterToNumber(letter);                             
             i++;               
                    if (i == roman.length())
                       {                  
                        decimal += number;
                    }
                    else
                        {
                      int nextNumber = letterToNumber(roman.charAt(i));
                      if (nextNumber > number) 
                           {
                             decimal += (nextNumber - number);
                             i++;
                      }
                      else
                             {
                            decimal += number;
                         }
                    }
              
            } 
                num = decimal;          
       }     
       private int letterToNumber(char letter)
         {            
          switch (letter)
             {
             case 'I':  return 1;
             case 'V':  return 5;
             case 'X':  return 10;
             case 'L':  return 50;
             case 'C':  return 100;
             case 'D':  return 500;
             case 'M':  return 1000;
             default:   return -1;
          }
       }       
     
     public String toString()
      {
          String roman = "";  
          int N = num;                
              for (int i = 0; i < numbers.length; i++)
              {
             while (N >= numbers[i])
                 {
                roman += letters[i];
                N -= numbers[i];
             }
          }
             roman = roman.toUpperCase();
          return roman;
       }       
      
       public int toInt()
         {           
          return num;
       }
 
}
