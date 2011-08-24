object SameDigits {
  def main(args: Array[String]) {
    val candidates =
      for (i <- 1 to 150000
          if ((1 to 6).map(_ * i).map(_.toString.sorted).forall(_ == i.toString.sorted)))
          yield i
    
    println(candidates.head)
  }
}
