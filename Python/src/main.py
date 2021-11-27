import sys

from bruteforce import bruteforce_password

def main():
    password = sys.argv[1]
    min_length = int(sys.argv[2])
    max_length = int(sys.argv[3])

    result = bruteforce_password(password, min_length, max_length)

    print("Cracked the password in", result, "guesses")

if __name__ == "__main__":
    main()