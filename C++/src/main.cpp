#include <iostream>
#include "bruteforcer.cpp"
using namespace std;

int main(int argc, char** argv) {
    string password = argv[1];
    unsigned short int min_length = atoi(argv[2]); 
    unsigned short int max_length = atoi(argv[3]);
    
    Bruteforcer farce(password, min_length, max_length);

    long result = farce.break_password();

    printf("Cracked the password in %ld guesses! \n", result);

    return 0;
}