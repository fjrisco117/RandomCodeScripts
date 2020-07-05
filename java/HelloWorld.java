import java.util.*;
import ann.easyio.*;
public class HelloWorld
{
    public static void main(String[] args)
    {
        Date currentDate = new Date();
        String today = currentDate.toString();
        Screen theScreen = new Screen();
        System.out.println("Hello World!!"+ today);
    }
}