object Rectangles {
  private val target = 2000000
  
  def main(args: Array[String]) {    
    var lowerWidth = 1
    var upperLen = 2000
    var minDelta = 1000 
    var minArea = lowerWidth * upperLen
   
    for (w <- 1 to 1000) {
      while (numRects(w, upperLen) > target) {
        upperLen -= 1
      } 
      
      val localDelta = minLocalDelta(w, upperLen)
      if (localDelta._1 < minDelta) {
        minDelta = localDelta._1
        minArea = localDelta._2 
      }
    }  

    println(minArea)
  }

  private def minLocalDelta(w: Int, upperLen: Int) = {
    val d1 = delta(w, upperLen)
    val d2 = delta(w, upperLen + 1)
    if (d1 < d2) {
      (d1 -> upperLen * w)
    } else {
      (d2 -> (upperLen + 1) * w)
    }
  }

  private def delta(w: Int, upperLen: Int) = math.abs(numRects(w, upperLen) - target)

  private def numRects(gridWidth: Int, gridLen:Int) = {
    var rects = 0
    for (w <- 1 to gridWidth) {
      for (l <- 1 to gridLen) {
        rects += numRectsOfSize(w, l, gridWidth, gridLen)
      }
    }
    rects
  }
 
  private def numRectsOfSize(width: Int, len: Int, gridWidth: Int, gridLen: Int) = {
    numOnAxis(width, gridWidth) * numOnAxis(len, gridLen)
  }

  private def numOnAxis(width: Int, gridWidth: Int) = gridWidth - width + 1
}
