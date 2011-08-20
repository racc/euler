import scala.annotation.tailrec

object Sequence {
	def main(args: Array[String]) {
		var maxLen = 0L
		var maxVar = 1L
		for(i <- 1 until 1000000) {
			val len = sequenceLen(i)
			if (len > maxLen) {
				maxLen = len
				maxVar = i	
			}
		}
		
		println("Sequence %d, length %d".format(maxVar, maxLen))
	}

	private def sequenceLen(x: Long, len: Long = 1): Long = term(x) match { 	 
		case 1 => len
		case x => sequenceLen(x, len + 1)
	}
	
	private	def term(x: Long): Long = {
		if (x % 2 == 0) {
			x / 2
		}	else {
			3 * x + 1
		}
	}
}
