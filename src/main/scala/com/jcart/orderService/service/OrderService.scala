package com.jcart.orderService.service

import akka.actor.ActorSystem
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

trait OrderService {
  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer

  val routes: Route = path("hello") {
    get {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "Hello Akka-HTTP"))
    }
  }
}
