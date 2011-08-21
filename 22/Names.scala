import scala.io.Source

object Names {
	val AlphaReadjustFactor = 64
	
	def main(args: Array[String]) {
		val content = Source.fromFile("names.txt").mkString.replace("\"", "").split(",")
		scala.util.Sorting.quickSort(content)
		val scores = { 
			for(i <- content.indices) 
				yield (content(i).map(_.toInt - AlphaReadjustFactor).reduce(_ + _) * (i + 1))
		}
		println(scores.reduce(_ + _))
	}
}
