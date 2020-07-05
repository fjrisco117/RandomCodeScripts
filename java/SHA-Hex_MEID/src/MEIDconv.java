import java.math.BigInteger;
import java.security.*;
import java.io.*;
import java.util.*;

public class MEIDconv{
    
    private String hexMEID;
    private int MEIDsize;
    
    public MEIDconv(String MEID, int size){
        
        hexMEID = MEID;
        MEIDsize = size;
        
    }
  
    
    public String hextoDecMancode(){
        
        //convert manufacturer num portion of MEID first, must be 8 in length
         BigInteger manNum = new BigInteger(hexMEID.substring(0,8),16);
         //convert manufacturer code to string
         String mancode = manNum.toString();
         //System.out.println("Manufactoring decimal number: "+mancode);
         return mancode;
         
    }
    
    public String hextoDecSerialNum(){
         
         //then convert serial part of MEID, must be 6 in length         
         BigInteger serialNum = new BigInteger(hexMEID.substring(8),16);
         //convert serial num back to string
         String seNum = serialNum.toString();
         
         while(seNum.length()<8){
             seNum = "0"+ seNum;             
         }
         
         //System.out.println("Serial decimal number: "+seNum);
         return seNum; 
         
    }
    
    public String decMEID(){        
        
        String decMEIDnum;
        //concatenate manufacturer and serial codes
        decMEIDnum = hextoDecMancode()+hextoDecSerialNum(); 
        return decMEIDnum;
        
    }
    
    public void decMEIDDisplay(){
        
       System.out.println( decMEID());
       
    }  
    
    public void sha1() throws NoSuchAlgorithmException {
        
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        
        byte[] b = new BigInteger(hexMEID,16).toByteArray();
 
        // skip the first byte set by BigInteger and retain only 7 bytes (length of MEID)
        byte[] result = mDigest.digest(Arrays.copyOfRange(b, 1, 8));       
        
        // create a string that begins with '80'
        StringBuilder sb = new StringBuilder("80");
        
        // add 80 to the last 3 bytes/ 6 digits of the SHA-1 hash
        for (int i = 17; i <20; i++) {
        
            sb.append(Integer.toHexString((result[i] & 0xff) | 0x100).substring(1));

        }
        
        String pESN = sb.toString().toUpperCase();
        System.out.println("pESN in HEX: "+ pESN);
        //convert to dec pESN after 80
        BigInteger pESNDEC = new BigInteger(pESN.substring(2),16);

        String pESN_DEC = pESNDEC.toString();
        while(pESN_DEC.length()<8){
             pESN_DEC = "0"+ pESN_DEC;             
         }
        //80 from hex pESN is converted to 128 and added in front of dec pesn
        System.out.println("pESN in DEC: "+"128"+pESN_DEC);

        metroMSL("128"+pESN_DEC);
    }
    
    public void metroMSL(String pESN){
        
        //String pESN = "12811838073";
        
        int[] n = new int[pESN.length()];
        
        for(int i = 0; i < pESN.length(); i++){
            n[i] = Character.digit(pESN.charAt(i),10);
        }
               
                
        long msl1 = ((int)Math.pow(2,(5 + n[0] + n[1] + n[2]))- 1);
        long msl2 = (Integer.parseInt(pESN.substring(8)) + 199);
        long msl3 = (23 + n[3] + n[4] + n[5] + n[6] + n[7] + n[8] + n[9] + n[10]); 
        
        BigInteger msl = BigInteger.valueOf((msl1*msl2*msl3));        
        
        String mymsl = msl.toString();

        System.out.println("MSL code is: " + mymsl.substring(mymsl.length() - 6));
        
        
    }
        
}