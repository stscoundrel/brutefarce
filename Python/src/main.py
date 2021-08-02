import sys

from bruteforce import bruteforce_password

def main():
    password = sys.argv[1]
    min_length = sys.argv[2]
    max_length = sys.argv[3]

    result = bruteforce_password(password, min_length, max_length)

    print("Cracked the password in", result, "guesses")

main()