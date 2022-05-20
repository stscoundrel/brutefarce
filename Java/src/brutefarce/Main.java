package brutefarce;

public class Main {
   public static void main(String args[]) {
      if (args.length < 3) {
         System.out.println(("Too few arguments provided. Provide password, min length and max length"));
         System.exit(1);
      }
      
      String password = args[0];
      int minLength = Integer.parseInt(args[1]);
      int maxLength = Integer.parseInt(args[2]);

      Bruteforcer bruteforcer = new Bruteforcer(password, minLength, maxLength);

      long guessesToBreak = bruteforcer.breakPassword();

      System.out.println("Cracked the password in " + guessesToBreak + " guesses!");

   }
}