package brutefarce;

public class Main {
   public static void main(String args[]) {
      if (args.length < 3) {
         System.out.println(("Too few arguments provided. Provide password, min length and max length"));
         System.exit(1);
      }

   }
}