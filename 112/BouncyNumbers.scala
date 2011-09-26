object BouncyNumbers {
  def main(args: Array[String]) {   
    val limit = 10000000
    var numBouncy = 0 
    for (i <- 0 to limit) {
      if(isBouncy(i)) {
        numBouncy += 1
        if (numBouncy / i.toDouble >= 0.99) {
          println(i)
          return
        }
      } 
    } 
  }
  
  def isBouncy(x: Int): Boolean = {
    val str = x.toString
    val sorted = str.sorted  
    str != sorted && str != sorted.reverse
  }
}
