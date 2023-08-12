package com.rockthejvm

import com.rockthejvm.PatternMatching2.Person

// pattern matching with out using case class and defining unapply() ourselves
object PatternMatching2 extends  App{
  class Person(val name: String, val age: Int)
  object Person {
    def apply(name:String, age:Int) = new Person(name, age)
    def unapply(p: Person): Option[(String, Int)] = Some(p.name, p.age)
  }

  val bob = Person("Bob", 43) // Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "Something else"
  }
  print(personGreeting)
}
