package server

import akka.actor._
import com.typesafe.config.ConfigFactory
import org.mashupbots.socko.webserver.{WebServerConfig, WebServer}
import org.mashupbots.socko.routes._
import calc.FactorialActor
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.{ExecutionContext, duration}
import java.util.concurrent.TimeUnit
import ExecutionContext.Implicits.global
import scala.util.Success

class RestServer {

  def run (args: Array[String]): Unit = {
    lazy val servicePort = ConfigFactory.load().getInt("service.port")
    implicit val timeout = Timeout(50, TimeUnit.MILLISECONDS)
    val actorSystem = ActorSystem("RESTServer")

    val routes = Routes {
      case HttpRequest(request) => request match {
        case GET(PathSegments(action :: Nil)) & QueryString(param : String) if action.equals("factorial") =>
          val factorialFuture = actorSystem.actorOf(Props[FactorialActor]) ? Integer.parseInt(param.split('=')(1))
          factorialFuture.onComplete(x => x match {
            case Success(result) => request.response.write(result.toString)
            case _ => System.out.println("E")
          })

        case _ => request.channel.close()
      }

      case _ =>
    }

    new WebServer(WebServerConfig(port = servicePort),
      routes,
      actorSystem
    ).start()
  }
}
