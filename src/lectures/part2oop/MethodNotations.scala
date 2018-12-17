package lectures.part2oop

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} hangs out with ${person.name}"
    def unary_! : String = s"$name, what the heck!"
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    def +(string: String) = new Person(s"$name ($string)", favoriteMovie)
    def unary_+ = new Person(name, favoriteMovie, age + 1)
    def learns(subj: String)  = s"$name learns $subj"
    def learnsScala = learns("Scala")
    def apply(n: Int) = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //equivalent
  //infix notation = operator notation

  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS

  //prefix notation
  val x  = -1 //equivalent to 1.unary_-
  val y = 1.unary_-
  //unary_prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive) //only for methods without parameters

  println(mary.apply())
  println(mary()) //equivalent


  val newMary = mary + "the coach"
  val olderMary = +mary
  println(olderMary( 2))
  println(olderMary.age)

  println(newMary learns "English")
  println(newMary learnsScala)





}
