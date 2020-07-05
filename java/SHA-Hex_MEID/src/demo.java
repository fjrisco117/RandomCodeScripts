import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.swing.*;
//import java.math.*;

public class demo{
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
        //Scanner input = new Scanner(System.in);
        
        //System.out.println("Enter MEID in HEX");
        String hexMEID = JOptionPane.showInputDialog("Enter MEID in Hex");//input.next();
        int meidSize = hexMEID.length();
        
        //check if MEID is hex       
        
        /* Check string length before proceeding */
        while (meidSize != 14){
            //System.out.println("Your string is not the right length");
            hexMEID = JOptionPane.showInputDialog("Wrong entry. Enter MEID in Hex");//input.next();
            meidSize = hexMEID.length(); 
        }
        
        MEIDconv meidNum = new MEIDconv(hexMEID, meidSize);        
        meidNum.decMEIDDisplay();
        meidNum.sha1();
       
    }
}   