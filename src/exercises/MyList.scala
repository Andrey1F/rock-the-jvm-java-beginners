package exercises

abstract class MyList [+A]{

  /*

   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B>:A](n: B) : MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  //concatenation
  def ++[B>:A](list: MyList[B]): MyList[B]

}

case object EmptyList extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B>:Nothing](n: B): MyList[B] = new Cons[B](n, EmptyList)

  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyList

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B>:A](n: B): MyList[B] = new Cons[B](n, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons[B](transformer.transform(head), tail.map(transformer))
  }

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons[A](h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)

  /*
  n +=> [n, n+1]
   */
  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }


}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

class Animal
class Cat extends Animal
class Dog extends Animal

object ListTest extends App {
  val tomCat = new Cat
  val topDog = new Dog
  val listOfDogs: MyList[Dog] = new Cons[Dog](topDog, EmptyList)
  println(listOfDogs.add(tomCat))

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons[Int](3, EmptyList)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, new Cons[Int](6, EmptyList)))
  val listOfStrings = new Cons("One", new Cons("Two", new Cons("Three", EmptyList)))

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem*2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element%2 == 0
  }))

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons[Int](elem, new Cons[Int](elem + 1, EmptyList))
  }))

  val clonedListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons[Int](3, EmptyList)))
  println(listOfIntegers == clonedListOfIntegers)

}


