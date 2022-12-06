package brutefarce

import java.util.concurrent.ThreadLocalRandom

class Bruteforcer(password: String, minLength: Int, maxLength: Int) {
  val ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"
  private var guesses: Long = 1
  private var isNotCracked = true

  private def getGuessLength(): Int = ThreadLocalRandom.current().nextInt(minLength, maxLength + 1)

  private def newGuess(guessLength: Int): String = {
    val stringBuilder = new StringBuilder(guessLength)

    for (i <- 0 until guessLength) {
      val randomCharacter = ALPHANUMERIC.charAt(ThreadLocalRandom.current().nextInt(0, ALPHANUMERIC.length))
      stringBuilder.append(randomCharacter)
    }

    stringBuilder.toString()
  }

  def breakPassword(): Long = {
    while (isNotCracked) {
      val currentGuess = newGuess(getGuessLength())

      println(s"$guesses. Guess is $currentGuess")

      if (currentGuess.equals(password)) {
        isNotCracked = false
        println(s"Found a match! $currentGuess")
      }

      guesses += 1
    }

    guesses
  }
}