module Bruteforce
open System

[<Literal>] 
let alphanumberic: string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

let NewGuess (min: int) (max: int) : string =
    let random = Random()
    let mutable length = min
    if min < max then
        length <- random.Next(min, max+1)

    let characters = [|for i: int in 1..length -> alphanumberic.[random.Next(alphanumberic.Length)]|]
    
    new String(characters)


let public BreakPassword (password: string, minLength: int, maxLength: int) : int =
    let mutable isNotBroken: bool = true
    let mutable guesses: int = 0

    while isNotBroken do
        let newGuess: string = NewGuess minLength maxLength

        printfn "%d. Guess is %s" guesses newGuess

        if newGuess.Equals(password) then
            isNotBroken <- false
        
        guesses <- guesses + 1

    guesses

    
