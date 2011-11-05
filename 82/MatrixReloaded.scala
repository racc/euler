import scala.collection.mutable._
import scala.io.Source
import scala.annotation.tailrec

object MatrixReloaded {
  // ( currentSum, currentCoord, lastCoord )  
  type PathEntry = Tuple3[Int, Tuple2[Int, Int], Tuple2[Int, Int]] 

  def main(args: Array[String]) {
    val lines = { 
      for (line <- Source.fromFile("matrix.txt").getLines()) 
        yield toIntArray(line)
    }.toArray

    // Order PathEntries by their sum
    val peOrdering: Ordering[PathEntry] = new Ordering[PathEntry] {
      def compare(x: PathEntry, y: PathEntry): Int = {
        y._1.compare(x._1) 
      }
    }

    val queue = new PriorityQueue[PathEntry]()(peOrdering)
    val minMap = new HashMap[Tuple2[Int, Int], Int]
    
    // Initialize queue 
    for (i <- 0 to lines.length - 1) {
      val coord = (lines(0).length - 1, i)
      val sum = lines(coord._2)(coord._1)
      minMap(coord) = sum
      queue += ((sum, coord, coord))
    }

    println(findSolution(queue, minMap, lines))
  }

  @tailrec
  private def findSolution(
    queue: PriorityQueue[PathEntry], 
    minMap: Map[Tuple2[Int, Int], Int],
    lines: Array[Array[Int]]
  ): Int = {
    val head = queue.dequeue    
    val sum = head._1
    val current = head._2
    val last = head._3
  
    if (current._1 == 0) {
      return sum
    }
    
    val nextPossible = Array(
      (current._1 - 1, current._2), // Left
      (current._1, current._2 + 1), // Up
      (current._1, current._2 - 1)  // Down
    ) 

    // Discount possibilities where we've already been, or that are out of bounds
    for (next <- nextPossible; if (next != last && next._2 >= 0 && next._2 < lines.length)) {
      val nextSum = sum + lines(next._2)(next._1)
      val nextInMinMap = minMap.contains(next)    
   
      // Only enqueue if it isn't in the minMap, or sum is less than minMap entry 
      if (!nextInMinMap || (nextInMinMap && minMap(next) > nextSum)) {
        minMap(next) = nextSum 
        queue += ((nextSum, next, current))
      }  
    }
   
    return findSolution(queue, minMap, lines)
  }

  private def toIntArray(line: String): Array[Int] = {
    line.split(",").map(_.toInt)
  }
}
