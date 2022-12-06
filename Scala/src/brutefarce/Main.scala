package brutefarce

object Main {
  def main(args: Array[String]): Unit =
  {
    if (args.length < 3) {
      println("Too few arguments provided. Provide password, min length and max length")
      System.exit(1)
    }

    val password = args(0)
    val minLength = args(1).toInt
    val maxLength = args(2).toInt

    val bruteforcer = new Bruteforcer(password, minLength, maxLength)
    val guessesToBreak = bruteforcer.breakPassword()

    println(s"Cracked the password in $guessesToBreak guesses!")
  }
}