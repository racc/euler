object PentagonalSumDiff {
  def main(args: Array[String]) {
    val pents = (1 to 2500).map(pentagonal)
    val pentsSet = pents.toSet
    var minDiff = Integer.MAX_VALUE
    for (p1 <- pents; p2 <- pents) {
      val diff = (p1 - p2).abs
      if (pentsSet.contains(p1 + p2) && pentsSet.contains(diff)) {
        if (diff < minDiff) {
          minDiff = diff
        } 
      }
    }

    println(minDiff)
  }

  private def pentagonal(n: Int) = n * (3 * n - 1) / 2
}
