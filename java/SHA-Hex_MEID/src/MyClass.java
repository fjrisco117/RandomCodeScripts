
import java.math.*;

public class MyClass{
    
    private String hexMEID;
    private BigInteger manNum;
    private BigInteger idNum;
    
    public MyClass(String aMEID){
        hexMEID = aMEID;
        manNum = new BigInteger(aMEID.substring(0,8),16);
        idNum = new BigInteger(aMEID.substring(8));
        
        
    }
    public String toString(){
        return hexMEID;
    }
    
    public void decMEIDconv()
    {
        BigInteger bi = new BigInteger(hexMEID, 16);
        
        
        System.out.println(bi);
        System.out.println(hexMEID.length());
        
        
        //int decMEID = Integer.parseInt(hexMEID, 16);
        //System.out.println("Decimal:="+ decMEID);

        //char[] stringArray;
        //stringArray = hexMEID.toCharArray();
    }
    
    public void hexMEIDtoDec(){
        
        //take hexMEID and splice it into 2 smaller strings
        
        // 1st string must be 8 in length
        
        // 2nd string must be 6 in length
        
        // convert both strings into BigInteger(s)
        
        // convert each BigInt(s) into strings and concatenate them
        
        // display to user
    }
    
    public void decMEID(){
        System.out.println(manNum);
        System.out.println(idNum);
    }
            
    
}