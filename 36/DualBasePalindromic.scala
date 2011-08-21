object DualBasePalindromic {
	def main(args: Array[String]) {
		val dualPalindromics = {
			for (i <- 1 to 1000000;	if isDualPalindromic(i))
				yield i
		}
		
		println(dualPalindromics.reduce(_ + _))
	}

	private def isDualPalindromic(x: Int): Boolean = {
		palindrome(x.toString()) && palindrome(x.toBinaryString)
	} 

	private def palindrome(s: String): Boolean = {
		s == s.reverse
	} 
}
