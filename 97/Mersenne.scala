object Mersenne {
  def main(args: Array[String]) {
    val exp = 7830456
    val lenLimit = 10
    var n = 2L
    for (i <- 1 to exp) {
      n = n << 1
      n = truncate(n, lenLimit)
    }
    
    val const = 28433L
    n = n * const + 1L
    println(truncate(n, lenLimit))
  }

  private def truncate(n: Long, lim: Int): Long = {
    var toTrunc = n
    val nStr = n.toString
    val nLen = nStr.length
    if (nLen > lim) {
      val truncNum = nStr.substring(nLen - lim, nLen)
      toTrunc = truncNum.toLong 
    }
    toTrunc
  }
}
