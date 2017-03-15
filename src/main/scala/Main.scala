import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.FromConfig
import akka.io.IO
import spray.can.Http
import akka.actor.Actor
import spray.routing.HttpService

case class Bla(a: String)

trait RestAPI extends HttpService {
//  val someObj = new 
//  val annotationService: AnnotationService

  def route = {
    path("") {
      get {
        complete {"hello"}
      }
    }
  }
}

class TestActor extends Actor with RestAPI {

  def actorRefFactory = context

  def receive = runRoute(route)
}

case class What(s: String)

object TestServer {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("reproduce")
    val x = What("hello")
    val service = system.actorOf(Props(new TestActor()).withRouter(FromConfig), "restHandler")
     IO(Http) ! Http.Bind(service, "localhost", port = 1111)
  }
}
