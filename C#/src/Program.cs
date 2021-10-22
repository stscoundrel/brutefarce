using System;

namespace Brutefarce
{
    class Program
    {
        static void Main(string[] args)
        {
            if (args.Length < 3)
            {
                Console.WriteLine("Too few arguments provided. Provide password, min length and max length");
                Environment.Exit(0);
            }

            string password = args[0];
            int minLength = Int32.Parse(args[1]);
            int maxLength = Int32.Parse(args[2]);

            Bruteforce forcer = new Bruteforce(password, minLength, maxLength);
            int guessesToBreak = forcer.BreakPassword();

            Console.WriteLine("Cracked the password in {0} guesses!", guessesToBreak);
        }
    }
}
