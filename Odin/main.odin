package brutefarce

import "core:fmt"
import "core:os"
import "core:strconv"
import "core:math/rand"
import "core:unicode/utf8"


charset := [62]rune{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}

get_guess_length :: proc(min_length: int, max_length: int) -> int {
    length := rand.int_max(max_length + 1)

    if length < min_length {
        return min_length
    }

    return length
}

make_new_guess :: proc(min_length: int, max_length: int) -> string {
    guess: [dynamic]rune
    length := get_guess_length(min_length, max_length)
    
    for i in 0..=length - 1 {
        append(&guess, rand.choice(charset[:]))
    }

    return utf8.runes_to_string(guess[:])
}

bruteforce :: proc(password: string, min_length: int, max_length: int) -> int {
    guesses := 0

    for true {
        guesses += 1
        newGuess := make_new_guess(min_length, max_length)
        fmt.println(guesses, ". Guess is", newGuess)

        if newGuess == password {
			fmt.println("Found a match!", newGuess)
            return guesses
        }
    }

    return guesses
}

main :: proc() {
    args := os.args
    fmt.println(os.args)
    if len(args) != 4 { // Program + 3 args.
        fmt.println("Too few arguments provided. Provide password, min length and max length")
        return
    }

    password := args[1]
    min_length := strconv.atoi(args[2])
    max_length := strconv.atoi(args[3])    

    guesses := bruteforce(password, min_length, max_length)
    
	fmt.println("Cracked the password in",guesses, "guesses!")
}