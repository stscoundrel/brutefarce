#include <stdbool.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "bruteforce.h"

long bruteforce_randomly(char password[], int min_length, int max_length)
{
    srand(time(NULL));
    const char ALPHANUMERIC[62] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    bool is_not_cracked = true;
    unsigned long guesses = 1;

    while (is_not_cracked)
    {
        int length = rand() % max_length;

        if (length < min_length)
        {
            length = min_length;
        }

        char *current_guess = malloc(sizeof(char) * (length + 1));

        int i;
        for (i = 0; i < length; i++)
        {
            int random_number = rand() % (sizeof(ALPHANUMERIC) - 1);
            char random_char = ALPHANUMERIC[random_number];
            current_guess[i] = random_char;
        }

        printf("%lu guess is: %s \n", guesses, current_guess);

        if (strcmp(password, current_guess) == 0)
        {
            printf("Found a match!! \n");
            printf("%s \n", current_guess);
            is_not_cracked = false;
        }

        guesses++;

        // https://www.youtube.com/watch?v=Fgb8l2Ve8vo
        free(current_guess);
    }

    return guesses;
}