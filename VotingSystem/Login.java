package VotingSystem;

import java.util.Scanner;

public class Login {
    void login( ) {
      Scanner scan = new Scanner(System.in);
        System.out.println("Authorized person's Name");
      String name=scan.nextLine();
      System.out.println("Enter Authorize Id  ");
      String Id = scan.next();
      if ((Id.equals("Voting"))&&(name.equals("Puja"))) {
          System.out.println("Authorized login successfully ");
      } else {
          System.out.println("you are not authorize person ");
          System.exit(1);
      }

  }
    
 public void stopVotingProgramme(){
   Scanner scan = new Scanner(System.in);
   System.out.println("Voting Time is Finished. Enter Authorizes password for Stop voting Program");
   String Id = scan.next();
   if ((Id.equals("Voting"))) {
       System.out.println("Voting programme is stopped. NOW Start vote count and public final result ");
   } else {
       System.out.println("Incorrect Authorizes Id Please try again ");
   }

 
}
}