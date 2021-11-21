import os, system, strutils

include bruteforce

if paramCount() < 3:
    echo "Too few arguments provided. Provide password, min length and max length"
    quit(QuitFailure)

let
  minLength: int = parseInt(paramStr(1))
  maxLength: int = parseInt(paramStr(2))
  password: string = paramStr(3)

let totalGuesses: int =  bruteforce(minLength, maxLength, password)

echo "Cracked the password in ", totalGuesses, " guesses!"
quit(QuitSuccess)