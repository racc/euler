import scala.io.Source

object Passcode {
  def main(args: Array[String]) {
    val attempts = Source.fromFile("keylog.txt").getLines().toSet
    val orderings = (for (i <- 0 to 9) yield Array(0,0,0,0,0,0,0,0,0,0)).toArray

    for (a <- attempts) {
      for (l <- (0 to 2)) {
        for (h <- ((l+1) to 2)) {
          val lower = a(l).toInt - 48
          val higher = a(h).toInt - 48
          orderings(lower)(higher) += 1
        }
      }      
    }
    
    println(attempts)  
    for (o <- (0 to 9)) {
      println("%d %s".format(o, orderings(o).deep.toString))
    }

    println("Using visual analysis 73162890")
  }
}
