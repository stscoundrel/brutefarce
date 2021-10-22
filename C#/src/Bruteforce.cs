using System;
using System.Linq;

namespace Brutefarce
{
    class Bruteforce
    {

        private const string Alphanumberic = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        private string Password;
        private int MinLength;
        private int MaxLength;
        private int Guesses = 1;
        private bool IsNotCracked = true;
        private Random Random;

        public Bruteforce(string password, int minLength, int maxLength)
        {
            Password = password;
            MinLength = minLength;
            MaxLength = maxLength;
            Random = new Random();
        }

        private int GuessLength()
        {
            return Random.Next(MinLength, MaxLength);
        }

        private string NewGuess(int length)
        {
            return new string(Enumerable.Range(1, length).Select(_ => Alphanumberic[Random.Next(Alphanumberic.Length)]).ToArray());
        }

        public int BreakPassword()
        {
            while (IsNotCracked)
            {
                int length = GuessLength();
                string currentGuess = NewGuess(length);

                Console.WriteLine("{0}. Guess is {1}", Guesses, currentGuess);

                if (currentGuess.Equals(Password))
                {
                    Console.WriteLine("Found a match! {0}", currentGuess.ToString());
                    IsNotCracked = false;
                }

                Guesses++;
            }

            return Guesses;
        }
    }
}
