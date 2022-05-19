#pragma once
#include <string>
using namespace std;

namespace Brutefarce
{
    class Bruteforcer
    {
    public:
        Bruteforcer(string password_to_crack, int min, int max);
        long int break_password();
    private:
        string password;
        unsigned short int min_length;
        unsigned short int max_length;
        long int guesses;
        string get_alphanumeric();
        int guess_length();        
        char get_random_char();
    };
}