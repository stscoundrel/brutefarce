package brutefarce

class Bruteforcer(val password: String, val minLength: Int, val maxLength: Int) {
    private val ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"
    private var guesses: Long = 1

    private fun getGuessLength(): Int {
        return (minLength..maxLength).random()
    }

    private fun newGuess(guessLength: Int): String {
        val stringBuilder = StringBuilder(guessLength)
    
        repeat(guessLength) {
            val randomCharacter = ALPHANUMERIC[(0..ALPHANUMERIC.length - 1).random()]
            stringBuilder.append(randomCharacter)
        }
    
        return stringBuilder.toString()
    }

    fun breakPassword(): Long {
        while (true) {
            val currentGuess = newGuess(getGuessLength())

            println("$guesses. Guess is $currentGuess")

            if (currentGuess == password) {
                println("Found a match! $currentGuess")
                return guesses
            }

            guesses += 1
        }
    }
}




