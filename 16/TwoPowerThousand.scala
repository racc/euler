import java.math.BigInteger
object TwoPowerThousand {
	def main(args: Array[String]) {
		val number = new BigInteger("2")	
		println(number.pow(1000).toString().map(_.toString.toInt).sum)
	}
}
