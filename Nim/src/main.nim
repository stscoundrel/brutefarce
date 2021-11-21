import os
import system
import strutils

if paramCount() < 3:
    echo "Too few arguments provided. Provide password, min length and max length"
    quit(QuitFailure)

let
  minLength: int = parseInt(paramStr(1))
  maxLength: int = parseInt(paramStr(2))
  password: string = paramStr(3)


echo minLength
echo maxLength
echo password