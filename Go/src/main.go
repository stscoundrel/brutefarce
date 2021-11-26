package main

import (
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

	minLength, minErr := strconv.Atoi(args[0])
	maxLength, maxErr := strconv.Atoi(args[1])
	password := args[2]

	if minErr != nil || maxErr != nil {
		fmt.Println("Could not parse min & max length. Check you're using numbers")
		os.Exit(1)
	}

	fmt.Println(minLength)
	fmt.Println(maxLength)
	fmt.Println(password)
}
