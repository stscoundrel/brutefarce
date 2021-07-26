#include <string>
using namespace std;

class Bruteforcer {
    public:
        Bruteforcer(string password_to_crack, int min, int max) {
            password = password_to_crack;
            min_length = min;
            max_length = max;
            guesses = 1;
        }
        string get_alphanumeric() {
            return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        }
        int guess_length() {
            int guess_length = rand() % (max_length + 1);

            if( guess_length < min_length ) {
                return min_length;
            }

            return guess_length;
        }
        char get_random_char() {
            string alphanumeric = get_alphanumeric();
            int random_number = rand() % (alphanumeric.length() - 1);

            return alphanumeric[random_number];
        }
        long int break_password() {
            bool is_not_cracked = true;

            while(is_not_cracked) {
                string current_guess = "";
                int length = guess_length();

                for(int i = 0; i < length; i++){
                    current_guess.push_back(get_random_char());
                }

                printf("%ld guess is: %s \n", guesses, current_guess.c_str());

                if(password.compare(current_guess) == 0) {
                    printf("Found a match!! \n");
                    printf("%s \n", current_guess.c_str());
                    is_not_cracked = false;
                }

                guesses++;
            }

            return guesses;
        }
    private:
        string password;
        unsigned short int min_length;
        unsigned short int max_length;
        long int guesses;        
};