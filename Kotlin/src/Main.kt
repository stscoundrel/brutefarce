package brutefarce

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 3) {
            println("Too few arguments provided. Provide password, min length and max length")
            System.exit(1)
        }

        val password = args[0]
        val minLength = args[1].toInt()
        val maxLength = args[2].toInt()

        val bruteforcer = Bruteforcer(password, minLength, maxLength)
        val guessesToBreak = bruteforcer.breakPassword()

        println("Cracked the password in $guessesToBreak guesses!")
    }
}