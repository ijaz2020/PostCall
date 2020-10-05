object Solution {
  def choices[A](cs: Set[A]): Set[IndexedSeq[A]] = {
    if(cs.isEmpty) Set(IndexedSeq())
    else cs.flatMap{a => choices(cs-a).map(a +: _)}
  }

  def readLine() = Console.in.readLine()

  def main(args: Array[String]) {
    val text = readLine()
    val questions = (1 to 5).map(_ => readLine())
    val answers = readLine().split(";")

    Problem(text, questions, answers).answers.foreach(println)
  }

}

case class Problem(text: String, questions: IndexedSeq[String], options: IndexedSeq[String]){
  val optionRanges = options.map{op =>
    getRanges(op)
  }

  val questionWordRanges = questions.map{q =>
    q.split("[^\\p{L}\\p{Nd}]+").toSet.map{getRanges}
  }


  def answers: IndexedSeq[String] = {
    val n = questions.length
    val (bestGrad, bestChoice) = Solution.choices((0 until n).toSet).map{ as =>
      val grads = (0 until n).map{ i =>
        gradOfQAndA(questionWordRanges(i), optionRanges(as(i)))
      }
      (grads, as)
    }.maxBy(_._1.sum)
    //    println(s"bestScore $bestGrad")
    bestChoice.map(i => options(i))
  }

  def getRanges(s: String): IndexedSeq[TextRange] = {
    val len = s.length
    var ranges = IndexedSeq[TextRange]()
    def loop(fromIndex: Int): Unit = {
      val start = text.indexOf(s,fromIndex)
      if(start != -1){
        val end = start + len
        ranges = ranges :+ TextRange(start, end)
        loop(end)
      }
    }
    loop(0)
    ranges
  }


  def gradOfQAndA(q: Set[IndexedSeq[TextRange]], as: IndexedSeq[TextRange]): Double = {
    def gradOfDis(d: Int): Double = {
      val maxDis = 50
      if(d <= 0 || d > maxDis) 0.0
      else maxDis - d
    }

    as.map{ a =>
      var grad = 0.0
      for{
        rs <- q if rs.nonEmpty
      } {
        grad += rs.map(r => gradOfDis(a.distanceTo(r))).max
      }
      grad
    }.max
  }
}

case class TextRange(start: Int, end: Int){
  def distanceTo(r: TextRange) = {
    if(r.end < start) start - r.end
    else if(r.start > end) r.start - end
    else 0
  }
}
