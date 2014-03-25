package calc

import akka.actor.Actor

class FactorialActor extends Actor {
  override def receive: Actor.Receive = {
    case mess : Int => sender ! factorial(mess)
      context.stop(self)

    case _ =>
  }

  //TODO: Rewrite to tailrec
  def factorial (n : Int) : Int = {
    n match {
      case a if a < 2 => a
      case _@a => a * factorial(a - 1)
    }

  }
}
