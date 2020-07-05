import java.util.*;

public class Welcome{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Welcome to Java"+ num);
        classdemo myclass = new classdemo();
        myclass.sayanything();
        
    }
}