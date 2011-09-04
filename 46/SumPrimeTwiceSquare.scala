import scala.annotation.tailrec

object SumPrimeTwiceSquare {
  private val Limit = 10000
  private val PrimesList: List[Int] = primes(Limit)

  def main(args: Array[String]) {
    println((9 to Limit by 2).filterNot(PrimesList.contains(_)).find(conjectureDisproved(_)).get)
  }
  
  private def conjectureDisproved(x: Int) = {
    PrimesList.filter(_ < x).find(p => isInt(math.sqrt((x - p)/2.0d))) == None
  }

  private def isInt(x: Double) = x.toInt == x

  private def primes(x: Int): List[Int] = {
    val lim = math.sqrt(x).ceil.toInt
    val primes = 2::(3 to x by 2).toList
    sieve(primes, lim, 3) 
  }

  @tailrec
  private def sieve(primes: List[Int], lim: Int, next: Int): List[Int] = {
    if (next > lim) {
      return primes
    } else {
      sieve(primes.filter(x => x % next != 0 || x == next), lim, next + 1) 
    }
  }
}
