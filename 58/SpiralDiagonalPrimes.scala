import scala.annotation.tailrec
import java.math.BigInteger

object SpiralDiagonalPrimes {
  def main(args: Array[String]) {
    println(findSideLength(3, 1, 1.0, 0.0))
  }

  @tailrec
  private def findSideLength(layer: Int, lastCorner: Int, corners: Double, primes: Double): Int = {
    val ratio = (primes / corners)
    if (primes > 0 && (primes / corners) < 0.10001334019400454) {
      return layer
    }
  
    val cornersList = cornersFor(List(), lastCorner, layer, 4)
    val primeCount = cornersList.filter(isPrime(_)).size
    return findSideLength(layer + 2, cornersList.head, corners + 4, primes + primeCount)
  }

  private def isPrime(x: Int) = new BigInteger(x.toString).isProbablePrime(Integer.MAX_VALUE)
  
  @tailrec
  private def cornersFor(corners: List[Int], lastCorner: Int, layer: Int, n: Int): List[Int] = {
    if (n > 0) {
      val corner = lastCorner + layer - 1
      return cornersFor(corner::corners, corner, layer, n - 1) 
    } else {
      corners
    }
  }
}
