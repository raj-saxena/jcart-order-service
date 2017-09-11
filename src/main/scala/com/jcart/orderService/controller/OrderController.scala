package com.jcart.orderService.controller

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.jcart.orderService.service.OrderService

class OrderController(implicit val system: ActorSystem,
                      implicit val materializer: ActorMaterializer) extends OrderService {
  def startServer(address: String, port: Int) = {
    Http().bindAndHandle(routes, address, port)
  }
}
