import scala.io.Source
import scala.annotation.tailrec

object Matrix {
  def main(args: Array[String]) {
    val lines = Source.fromFile("matrix.txt").getLines()
    var prevSum = cumulativeSum(toIntArray(lines.next()))
    for (line <- lines) {
      val nextVals = toIntArray(line)
      val nextSum = getNextSum(prevSum, nextVals)
      prevSum = nextSum
    }

    println(prevSum.last)
  }
  
  @tailrec 
  private def getNextSum(
    prevSum: Array[Int], 
    nextVals: Array[Int], 
    nextSum: List[Int] = List.empty,
    i: Int = 0
  ): Array[Int] = i match {
    case 0 => {
      getNextSum(prevSum, nextVals, List(prevSum(0) + nextVals(0)), 1)
    }
    case x => {
      if (x == prevSum.length) {
        nextSum.reverse.toArray  
      } else {
        val min = scala.math.min(prevSum(x), nextSum.head)
        val sum = min + nextVals(x)
        getNextSum(prevSum, nextVals, sum::nextSum, i + 1)
      }
    }
  }

  @tailrec
  private def cumulativeSum(
    arr: Array[Int], 
    accum: List[Int] = List.empty, 
    i: Int = 0
  ): Array[Int] = i match {
    case 0 => {
      cumulativeSum(arr, List(arr(0)), 1)
    }
    case x => {
      if (x == arr.length) {
        accum.reverse.toArray
      } else {
        val sum = accum.head + arr(x)
        cumulativeSum(arr, sum::accum, i + 1)
      }
    }
  }

  private def toIntArray(line: String): Array[Int] = {
    line.split(",").map(_.toInt)
  }
}
