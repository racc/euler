class CircularPrimes(n: Int) extends scala.collection.Iterable[Int] {
	def iterator: Iterator[Int] = new CircularPrimesIterator(n)
}

class CircularPrimesIterator(n: Int) extends scala.collection.Iterator[Int] {
	private var rotateString = n.toString
	private var timesToRotate = rotateString.length

	def hasNext: Boolean = (timesToRotate != 0)

	def next: Int = {
		val toReturn = rotateString.toInt
		rotateString = rotateString.tail + rotateString.head
		timesToRotate -= 1
		toReturn
	}
}

import java.math.BigInteger

object CircularPrimes {
	def main(args: Array[String]) {
		var circularPrimes =   
			for (i <- 2 to 1000000 if (new CircularPrimes(i).forall(isPrime(_))))
				yield i

 		println(circularPrimes.size)
	}


	private def isPrime(n: Int): Boolean = {
		new BigInteger(n.toString).isProbablePrime(Integer.MAX_VALUE)
	}
}

