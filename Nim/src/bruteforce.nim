import random

proc generateGuessLength(minLength: int, maxLength: int) : int =
  result = rand(minLength .. maxLength)

proc generateNewGuess(guessLength: int) : string =
  for _ in 1 .. guessLength:
    add(result, char(rand(int('A') .. int('z'))))

proc bruteforce(minLength: int, maxLength: int, password: string) : int =
  var isNotCracked = true
  var guesses: int = 1

  while isNotCracked:
    let guessLength: int = generateGuessLength(minLength, maxLength)
    let guess: string = generateNewGuess(guessLength)

    echo guesses, ". Guess is ", guess

    if guess == password:
      echo "Found a match! ", guess
      isNotCracked = false
      
    guesses += 1

  result = guesses