object MillionthPermutation {
	def main(args: Array[String]) {
		var i = 1
		for (p <- "0123456789".permutations) {
			if (i == 1000000) {
				println(p)
				return
			}
			i += 1
		}
	}
}

