object Triplet {
	def main(args: Array[String]) { 
		var i = 2
		var t = triple(i)
		var sum = t.sum

		do { 
			t = triple(i)
			sum = t.sum
			i += 1
		} while (1000 % sum != 0)
	
		val mult = 1000 / sum
		t = t.map { _ * mult }
			
		println(t.product)
	}

	private def triple(n: Int) = List(2*n, n*n - 1, n*n + 1)
}
