import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class RomanMain extends JFrame
{   
    private static JTextArea outputTA, inputTA; 
    private JLabel headingL; 
    private JLabel headingResult;    
    private JScrollPane scrollText, scrollText2;//creates the scroll 
                                                                                    
    private JButton convertB, exitB, clearB;
    private ConvertButtonHandler encrbHandler;  
    private ExitButtonHandler ebHandler;
    private ClearButtonHandler clbHandler;      
     
    private static int WIDTH = 370;
     private static int HEIGHT = 350;   
     
   public RomanMain()
    {


        Font font =  new Font("Courier New", Font.BOLD, 30);   
        Font font2 = new Font("Times New Roman", Font.BOLD, 20);
        Font font3 = new Font("Times New Roman", Font.BOLD, 36);
          
        headingL = new JLabel("Enter Your Roman Numeral",
        SwingConstants.CENTER);
        headingL.setFont(font2);
 
          
    inputTA = new JTextArea("",50,895) ;
       
    scrollText2 = new JScrollPane(inputTA);//adds the scroll feature to the outputTA
    scrollText2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 
    inputTA.setFont(font); 
    inputTA.setLineWrap(true);
    inputTA.setWrapStyleWord(true);

    outputTA = new JTextArea("",50,895) ;    
         
    scrollText = new JScrollPane(outputTA);//adds the scroll feature to the outputTA
    scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    outputTA.setFont(font); 
    outputTA.setLineWrap(true);
     outputTA.setWrapStyleWord(false);//set to false because the 
                                  
    outputTA.setEditable(false); 
         
    convertB = new JButton("Convert");
    encrbHandler = new ConvertButtonHandler();
    convertB.addActionListener(encrbHandler);
    convertB.setFont(font2);    
    

    headingResult = new JLabel("Result",
    SwingConstants.CENTER);
    headingResult.setFont(font2);

    exitB = new JButton("Exit");
    ebHandler = new ExitButtonHandler();
    exitB.addActionListener(ebHandler);
    exitB.setFont(font2);
      
    clearB = new JButton("Clear");
    clbHandler = new ClearButtonHandler();
    clearB.addActionListener(clbHandler);
    clearB.setFont(font2); 
      
    setTitle("Roman Numeral Conversion");                
    Container myWindow = getContentPane();
    myWindow.setLayout(null);
    


          convertB.setSize(200,40); 
          exitB.setSize(150, 30);
          clearB.setSize(150, 30);       
          headingL.setSize(425,40);              
          headingResult.setSize(425,40);                 
          scrollText2.setSize(370,40);       
          scrollText.setSize(370,40);             
           
          convertB.setLocation(90, 105);
          exitB.setLocation(195, 255);
          clearB.setLocation(15, 255);       
          scrollText2.setLocation(2,52);          
          scrollText.setLocation(2,185);        
          headingL.setLocation(-30,5);   
          headingResult.setLocation(-30,150);                 

                  
          myWindow.add(convertB);          
          myWindow.add(exitB);
          myWindow.add(clearB);
          myWindow.add(headingL);    
          myWindow.add(headingResult);        
          myWindow.add(scrollText2);         
          myWindow.add(scrollText);
 
           
       setSize(WIDTH, HEIGHT);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
      }
       
     private class ConvertButtonHandler implements ActionListener
    {
       public  void actionPerformed(ActionEvent e)                                      
       {            
         inputTA.setForeground(Color.blue);
                                    
            outputTA.setText("");
            outputTA.setForeground(Color.green);  
                         
            String roman = inputTA.getText();      
                 
      Roman N = new Roman(roman);
              
    outputTA.append( "" + N.toInt()); 
                                                         
        }
    }        
 
    private class ExitButtonHandler implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
           System.exit(0); 
       }
    }
      
     private class ClearButtonHandler implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
           inputTA.setText("");
             inputTA.setForeground(Color.black);
              outputTA.setText("");
              inputTA.requestFocusInWindow();
       }
     }                                   
     public static void main(String[] args)
    {                             
         
         RomanMain romanObject = new RomanMain();        
       romanObject.setLocationRelativeTo(null);
                                    
     }        
 
}
   
 
