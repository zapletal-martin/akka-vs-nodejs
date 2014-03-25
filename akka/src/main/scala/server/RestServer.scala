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
import org.jboss.netty.channel.ChannelFutureListener
import org.mashupbots.socko.events.HttpRequestEvent

class RestServer {

  def run (args: Array[String]): Unit = {
    lazy val servicePort = ConfigFactory.load().getInt("service.port")

    val actorSystem = ActorSystem("RESTServer")

    val routes = Routes {
      case HttpRequest(request) => request match {
        case GET(PathSegments(action :: Nil)) & QueryString(param : String) if action.equals("factorial") =>
          actorSystem.actorOf(Props[FactorialActor]) ! (Integer.parseInt(param.split('=')(1)), request)
      }
    }

    val webServer = new WebServer(WebServerConfig(port = servicePort),
      routes,
      actorSystem
    )

    webServer.start()

    Runtime.getRuntime.addShutdownHook(new Thread {
      override def run { webServer.stop() }
    })
  }
}
