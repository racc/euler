import java.math.BigInteger

object PrimeSum {
	def main(args: Array[String]) {
		val limit = new BigInteger("2000000")
		var result = new BigInteger("2")
		var nextPrime = result.nextProbablePrime()
	
		while (nextPrime.compareTo(limit) < 0) {
			result = result.add(nextPrime)
			nextPrime = nextPrime.nextProbablePrime()	
		}
		
		println(result)
	}
}
