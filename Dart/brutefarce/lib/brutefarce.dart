import 'dart:math';

const chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';

int getGuessLength(int minLength, int maxLength, Random random) {
  return minLength + random.nextInt(maxLength - minLength + 1);
}

String generatePassword(length, Random random) {
  return String.fromCharCodes(Iterable.generate(
      length, (_) => chars.codeUnitAt(random.nextInt(chars.length))));
}

int bruteforcePassword(String password, int minLength, int maxLength) {
  int guesses = 0;
  bool isNotCracked = true;
  final random = Random();

  while (isNotCracked) {
    guesses += 1;
    String newGuess =
        generatePassword(getGuessLength(minLength, maxLength, random), random);
    print("$guesses. Guess is $newGuess");

    if (newGuess == password) {
      isNotCracked = false;
      print("Found a match $newGuess!");
    }
  }

  return guesses;
}
