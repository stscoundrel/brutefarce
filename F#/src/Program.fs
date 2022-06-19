[<EntryPoint>]
let main args =
    
    if args.Length < 3 then
       printfn "Too few arguments provided. Provide password, min length and max length"

    let password :string = args[0]
    let minLength: byte = args[1] |> byte
    let maxLength: byte = args[2] |> byte

    printfn "%s" password
    printfn "%d" minLength
    printfn "%d" maxLength

    0