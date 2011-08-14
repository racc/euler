object Fib {
  def main(args: Array[String]) {
    var a = 1
    var b = 2
    var d = 2

    while (a < 4000000) {
      var c = a + b
      a = b
      b = c
      if (c % 2 == 0) { 
        d += c
      }
    }
    
    println(d)
  }
}
