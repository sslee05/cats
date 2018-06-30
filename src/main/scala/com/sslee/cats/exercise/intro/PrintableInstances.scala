package com.sslee.cats.exercise.intro

object PrintableInstances {
  implicit val stringPrintable = new Printable[String] {
    def format(value: String): String = value
  }
  
  implicit val intPrintable = new Printable[Int] {
    def format(value: Int): String = value.toString
  }
  
  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat): String = cat match {
      case Cat(name, age, color) => s"Name is $name, $age Years-old Color is $color"
    }
  }
}