package com.jcart.orderService

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.jcart.orderService.controller.OrderController

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object OrderServiceMain {
  val host = "localhost"
  val port = 8081

  def main(args: Array[String]) = {
    implicit val system = ActorSystem("order-service")
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val bindingFuture = new OrderController().startServer(host, port)

    println(s"Server online at http://$host:$port/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done

  }
}
