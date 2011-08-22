import scala.collection.Iterable
import scala.collection.Iterator
import java.math.BigInteger

class QuadraticIterator(a: Int, b: Int) extends Iterable[Int] {
  def iterator() = new Quadratic(a, b)
}

class Quadratic(a: Int, b: Int) extends Iterator[Int] {
  private var n = 0
  private var lastWasPrime = true
  
  def hasNext() = lastWasPrime
  def next() = { 
    val f = n * n + a * n + b
    lastWasPrime = new BigInteger(f.toString).isProbablePrime(Integer.MAX_VALUE) 
    n += 1
    f
  }
}

object Quadratic {
  private val Limit = 1000 

  def main(args: Array[String]) {
    var max = 0
    var maxA = 0
    var maxB = 0
  
    for (a <- -Limit to Limit) {
      for (b <- -Limit to Limit) {
        val size = new QuadraticIterator(a, b).size 
        if (size > max) {
          max = size 
          maxA = a
          maxB = b
        } 
      }
    }
    
    println(maxA * maxB)
  }
}
