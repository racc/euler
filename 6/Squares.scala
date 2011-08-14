object Squares {
	def main(args: Array[String]) {
	  println(diffSumOfSquaresAndSquareOfSum(100))
	}

	def diffSumOfSquaresAndSquareOfSum(x: Int) = {
		val sumOfSquares = (1 until (x+1)) reduceLeft((a, b) => a + b * b)
		val sum = (1 until (x+1)) reduceLeft((a, b) => a + b)
		sum * sum - sumOfSquares
	}
}
