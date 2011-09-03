import java.math.BigInteger

object PandigitalPrimes {
  def main(args: Array[String]) {
    val digits = "123456789"
    var max = 0 

    for (pandigitalNum <- 4 to 9) {
      for (perm <- digits.substring(0, pandigitalNum).permutations if isPrime(perm)) {
        val permInt = perm.toInt
        if (permInt > max) {
          max = permInt
        }
      }
    }

    println(max)
  }

  private def isPrime(n: String): Boolean = {
    new BigInteger(n).isProbablePrime(Integer.MAX_VALUE)
  }
}
