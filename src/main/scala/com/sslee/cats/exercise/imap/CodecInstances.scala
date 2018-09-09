package com.sslee.cats.exercise.imap

object CodecInstances {
  
  implicit val codecString = new Codec[String] {
    def encode(a: String): String = a
    def decode(s: String): String = s
  }
  
  implicit val codecDouble = 
    codecString.imap[Double](d => d.toString, s => s.toDouble)
    
  import com.sslee.cats.exercise.contramap.Box

  implicit def codecBox[A](implicit cd: Codec[A]) = 
    cd.imap[Box[A]](box => box.value, a => Box(a))
    
  
    
}