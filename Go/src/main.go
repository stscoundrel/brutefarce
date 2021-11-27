package main

import (
	"brutefarce/bruteforce"
	"fmt"
	"os"
	"strconv"
)

func main() {
	args := os.Args[1:]

	if len(args) < 3 {
		fmt.Println("Too few arguments provided. Provide password, min length and max length")
		os.Exit(1)
	}

	password := args[0]
	minLength, minErr := strconv.Atoi(args[1])
	maxLength, maxErr := strconv.Atoi(args[2])

	if minErr != nil || maxErr != nil {
		fmt.Println("Could not parse min & max length. Check you're using numbers")
		os.Exit(1)
	}

	totalGuesses := bruteforce.BreakPassword(minLength, maxLength, password)

	fmt.Println(fmt.Sprintf("Cracked the password in %d guesses!", totalGuesses))
}
