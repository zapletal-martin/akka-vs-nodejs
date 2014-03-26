package calc

import akka.actor.Actor
import org.mashupbots.socko.events.HttpRequestEvent
import scala.annotation.tailrec
import scala.math

class FactorialActor extends Actor {
  override def receive: Actor.Receive = {
    case (n : BigInt, request : HttpRequestEvent) =>
      request.response.write(factorial(n).toString)
      context.stop(self)
  }

  def factorial (n : BigInt) : BigInt = factorialRec(1, n)

  @tailrec
  private def factorialRec (product : BigInt, current : BigInt) : BigInt = {
    current match {
      case a if a < 2 => product
      case _@a => factorialRec(a * product, a - 1)
    }
  }
}
