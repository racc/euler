import scala.io.Source

object Triangle {
	def main(args: Array[String]) {
		var localMax = Array(0)

		for(line <- Source.fromFile(args(0)).getLines()) {
			val splitLine = line.split(" ").map(_.toInt)
			
			for (i <- 0 until splitLine.length) {
				val last = splitLine.length - 1 
				val max = i match { 
					case 0 => localMax.head
					case x => {
						if (x == last) 
							localMax.last 
						else 
							scala.math.max(localMax(i), localMax(i - 1))
					}
				}

				splitLine(i) = splitLine(i) + max
			}

			localMax = splitLine
		}

		println(localMax.max)
	}
}
