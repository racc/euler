object Grid {
	def main(args: Array[String]) {
		val gridSize = 21
		val grid = Array.fill(gridSize, gridSize)(0L)
		grid(0) = Array.fill(gridSize)(1L)
		
		for (i <- 1 until grid.length) {
			for (j <- 0 until grid(0).length) { 
				if (j == 0) {
					grid(i)(j) = 1L
				} else {
					grid(i)(j) = grid(i - 1)(j) + grid(i)(j - 1)
				}
			}
		}
		
//		println(grid.deep.mkString("\n")) 		
		println(grid(20)(20))
	}
}
