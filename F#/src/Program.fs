module Main

open Bruteforce

[<EntryPoint>]
let main (args: string[]) : int =
    
    if args.Length < 3 then
       printfn "Too few arguments provided. Provide password, min length and max length"

    let password :string = args[0]
    let minLength: byte = args[1] |> byte
    let maxLength: byte = args[2] |> byte

    let guessesToBreak: int = BreakPassword(password, minLength |> int, maxLength |> int)

    printfn "Cracked the password in %d guesses!" guessesToBreak

    0