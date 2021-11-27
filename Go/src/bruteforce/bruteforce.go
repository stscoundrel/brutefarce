package bruteforce

import (
	"fmt"
	"math/rand"
	"time"
)

const letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

func getGuessLength(minLength int, maxLength int) int {
	return rand.Intn(maxLength+1-minLength) + minLength
}

func getNewGuess(guessLength int) string {
	guess := make([]byte, guessLength)
	for i := range guess {
		guess[i] = letters[rand.Intn(len(letters))]
	}
	return string(guess)
}

func BreakPassword(minLength int, maxLength int, password string) (guesses int) {
	rand.Seed(time.Now().UnixNano())
	isNotCracked := true
	guesses = 1

	for isNotCracked {
		guessLength := getGuessLength(minLength, maxLength)
		guess := getNewGuess(guessLength)
		fmt.Println(guesses, ". Guess is ", guess)

		if guess == password {
			fmt.Println("Found a match! ", guess)
			isNotCracked = false
		}

		guesses += 1
	}

	return
}
