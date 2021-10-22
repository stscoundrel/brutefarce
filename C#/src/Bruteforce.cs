using System;

namespace Brutefarce
{
    class Bruteforce
    {
        private string Password;
        private int MinLength;
        private int MaxLength;

        public Bruteforce(string password, int minLength, int maxLength) {
            Password = password;
            MinLength = minLength;
            MaxLength = maxLength;
        }

        public int BreakPassword() {
            return new Random().Next(1, 12);
        }
    }
}
