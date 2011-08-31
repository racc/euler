object Perimeter {
  def main(args: Array[String]) {
    val limit = 1000
    val squares = (2 to limit).map(math.pow(_, 2)).toList
    val squaresSet = squares.toSet
    
    val sides = {
      for (i <- squares; j <- squares; if (squaresSet.contains(i + j)))
        yield List(i, j, i + j).map(math.sqrt(_))
    }.map(_.sum).filter(_ <= limit)

    val freq = sides.groupBy(x => x).mapValues(_.size)
    val maxValue = freq.values.max
    
    println(freq.find(_._2 == maxValue).get._1)
  }
}
