#include <stdio.h>

#include "bruteforce.c"

int main(int argc, char *argv[])
{
    char *password = argv[1];
    int min_length = atoi(argv[2]);
    int max_length = atoi(argv[3]);

    long result = bruteforce_randomly(password, min_length, max_length);

    printf("Cracked the password in %lu guesses! \n", result);
}