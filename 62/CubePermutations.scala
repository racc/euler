object CubePermutations {
  def main(args: Array[String]) {
    println((10 to 50000).map(math.pow(_, 3)).groupBy(_.toString().sorted).values.filter(_.size == 5).flatten.min)
  }
}
