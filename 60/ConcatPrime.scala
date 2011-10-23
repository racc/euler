import scala.collection.mutable.{HashMap => MutableMap}
import scala.collection.mutable.{Set => MutableSet}
import scala.collection.mutable.MultiMap 

object ConcatPrime {
  private val PrimeLimit = 99999999
  private val Primes = sieved(PrimeLimit)
  
  def main(args: Array[String]) {
    val concatPairs = 
      for (p <- Primes; val pairs = findConcatPairs(p); if (pairs.nonEmpty))
        yield pairs
     
    val pairs:MultiMap[Int, Int] = 
      new MutableMap[Int, MutableSet[Int]] with MultiMap[Int, Int]

    for (c <- concatPairs; t <- c) {
      pairs.addBinding(t._1, t._2)
      pairs.addBinding(t._2, t._1)
    } 
  
    val groups:MutableSet[Set[Int]] = MutableSet.empty

    for ((k, v) <- pairs) {
      findConcatGroups(Set(k), v.toSet, pairs, groups)
    }

    println(groups.map { _.sum }.min)
  }

  private def findConcatGroups(
    currentPairs: Set[Int],
    potentials: Set[Int],
    pairs: MultiMap[Int, Int],
    foundGroups: MutableSet[Set[Int]]
  ) {
    if (currentPairs.size == 5) {
      foundGroups += currentPairs
      return
    }
  
    for (p <- potentials; val cp = pairs(p); if (currentPairs subsetOf cp)) {
      findConcatGroups(currentPairs + p, potentials & cp, pairs, foundGroups)
    }
  }

  private def findConcatPairs(n: Int) = {
    val nStr = n.toString

    for (
      s <- 1 to nStr.length - 1; 
      val sp = nStr.splitAt(s);
      if (sp._1(0) != '0' &&
          sp._2(0) != '0' &&
          Primes.contains(sp._1.toInt) && 
          Primes.contains(sp._2.toInt) && 
          Primes.contains((sp._2 + sp._1).toInt)))
      yield (sp._1.toInt, sp._2.toInt)
  }

  private def sieved(n: Int): Set[Int] = {
    val primes = (0 to n).toArray
    val limit = math.sqrt(n).ceil.toInt
 
    for (s <- 2 to limit) {
      if (primes(s) != 0) {
        for (d <- (2 * s to n by s)) {
          primes(d) = 0
        } 
      }
    }

    primes.toSet - 0 - 1
  }
}
