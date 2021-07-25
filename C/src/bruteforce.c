#include <stdbool.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int bruteforce_randomly(char password[], int min_length, int max_length) {
    srand(time(NULL));
    const char ALPHANUMERIC[62] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    bool is_not_cracked = true;
    int guesses = 1;

    while(is_not_cracked) {
        int length = rand()% max_length;
        char *current_guess = malloc(sizeof(char) * (length +1));

        if( length < min_length ) {
            length = min_length;
        }

        int i;
        for(i = 0; i < length; i++){
            int random_number = rand() % (sizeof(ALPHANUMERIC) - 1);
            char random_char = ALPHANUMERIC[random_number];
            current_guess[i] = random_char;
        }

        printf("%d guess is: %s \n", guesses, current_guess);

        if(strcmp(password, current_guess) == 0) {
            printf("Found a match!! \n");
            printf("%s \n", current_guess);
            is_not_cracked = false;
        }

        guesses++;
    }

    return guesses;
}