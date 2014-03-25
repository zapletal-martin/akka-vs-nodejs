import server.RestServer

object Main extends App {
  override def main (args: Array[String]) = {
    val server = new RestServer
    server.run(args)
  }
}
