package com.jcart.orderService.service

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class OrderServiceSpec extends WordSpec with Matchers with ScalatestRouteTest with OrderService {

  "Order service" should {
    "say Hello-akka" in {
      Get("/hello") ~> routes ~> check {
        status.isSuccess() shouldEqual true
        responseAs[String] shouldEqual "Hello Akka-HTTP"
      }
    }
  }
}
