from random import randrange

def get_random_character():
    alphanumerical = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"
    random_position = randrange(len(alphanumerical))

    return alphanumerical[random_position]

def bruteforce_password(password, min_length, max_length):
    is_not_cracked = True
    guesses = 1

    while is_not_cracked:
        length = randrange(min_length, max_length)
        current_guess = ""

        for i in range(0, length):
            current_guess += get_random_character()
        
        print(guesses, "guess is:", current_guess)

        if current_guess == password:
            print("Found a match!")
            print(current_guess)
            is_not_cracked = False
        
        guesses += 1
    
    return guesses