package Hello;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Main_Class {
    // TODO Auto-generated method stub

    public static void main(String[] args) {

        // TODO Auto-generated method stub
    

    //int name;

    int number = 1;

    String input = null, menu;

    String name;

   

    //thought I had a lead on the adding score to each question.. but..

    double score1;

    double score2;

    double score3;

    double score4;

    double score5;

   

   

   

    Scanner in = new Scanner(System.in);

   

    //double option;

   

   // System.out.println("Introduction to Java Question Game\n");

//       System.out.println("Java Question Game is based on selecting the right answer.\n ");

       // menu options

  //     System.out.println("Main Menu:\n");

    //   System.out.println("\t1) See Rules\n");

     //  System.out.println("\t2) Play Game\n");

      // System.out.println("\t3) Exit\n");

   

       // pop up box to add name

    name = JOptionPane.showInputDialog("Enter your name");

   

    // pop up box to select menu
//do{
    menu = JOptionPane.showInputDialog("Make your selection below: \n"

                                    + " 1 - See Rules\n"

                                    + " 2 - Play Games\n"

                                    + " 3 - Exit");



    JFrame frame = new JFrame();  ///MARCOLOOK AT THIS, I THINK YOU MIGHT NEED IT
    
    //int choice;//=in.nextInt(); // YOU DONT NEED THIS

    int correctAnswer;

     

     correctAnswer = Integer.parseInt(input);

    //Get user's choice



    // choice = Integer.parseInt(menu);	

    //Display the title of the chosen module    
     

     switch (menu) {   //   //USE MENU INSTEAD

case "1": JOptionPane.showInternalMessageDialog (frame, "Rules:\n \"It is important to select the right answer, once there is no partial points on this game.\n ", "menu", JOptionPane.INFORMATION_MESSAGE);

                                                         //      + "There's 4 choices to select, and the total will be display at the end.\n"

                                                           //    + "Whoever get the most ammount of correct answer, wins the game.\n ", JOptionPane.INFORMATION_MESSAGE);

break;



// 3 questions from Chapter 1-2

case "2": JOptionPane.showInputDialog("1) What is pseudocode?\n" 

                                    +"A - It's an informal high-level description of the operating principle of a computer program or other algorithm.\n"

                                    +"B - It's a computer program algorithm used only for Java.\n"

                                    +"C - Pseudocode helps Java to decode encrypt files.\n"

                                   +"D - Option A and C");







		JOptionPane.showInputDialog("2) What is encapsulation?\n"

                                                    + "A - It's helps protect and encrypt Java code\n"

                                                    + "B - Encapsulation refers to the combining of data and code into a single object.\n"

                                                    + "C - .Encapsulation separates data from multiples objects\n"

                                                    + "D - Encapsulation is a form of protect the file.");





		JOptionPane.showInputDialog("3) What programming style means?\n"

                                                    + "A - It's a programming style to gives Java Web pages a better layout.\n"

                                                    + "B - Programming style it's part of key words.\n"

                                                    + "C - Programming style refers to the way source code is visually arranged.\n"

                                                    + "It includes techniques for consistently putting spaces and indentations in a program so visual cues are created\n"

                    								+ "D - None of the above\n");



// 2 more question added from Chapter 3



		JOptionPane.showInputDialog("4) What is relational operator?\n"

                                                    + "A - It's an operation to validate distinct values. \n"

                                                    + "B - A relational operator determines whether a specific relationship exists between two values.\n"

                                                    + "C - A relational operator helps to calculate equations only.\n"

                    								+ "D - Answer A and C.\n");



		JOptionPane.showInputDialog("5) What is boolean expression?\n"

                           							+ "A - A boolean expression is one that is either true or false.\n"

                                       				+ "B - Bollean expression it is a term of cyberbulling.\n"

                           							+ "C - A bollean expression is recommended to execute calculations math calculation.\n"

                    								+ "D - Boolean its a form of protect your code.\n");



//2 more questions from Chapter 4



		JOptionPane.showInputDialog("6) An Increment operators are..?\n"

        											+ "A - Operators that increment a quantlity of the graphic resolution.\n"

        											+ "B - Operators that increase a value by one.\n"

        											+ "C - Operators that help to add more characters on a array.\n"

                    								+ "D - None of the above.\n");

		JOptionPane.showInputDialog("7) The real operation that takes place just before the loop is called..?\n"

                    								+ "A - Variables.\n"

                    								+ "B - Integers.\n"

                    								+ "C - Priming read.\n"

                    								+ "D - Algorithm");





break;

case "3": System.exit(0);

       // break;


     

     }

//} while(!"3".equals(menu));  

}

   

}