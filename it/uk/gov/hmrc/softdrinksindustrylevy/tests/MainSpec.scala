package uk.gov.hmrc.softdrinksindustrylevy.tests

import play.api.test.WsTestClient
import uk.gov.hmrc.softdrinksindustrylevy.support.{IntegrationSpec, SDILActions}

import scala.concurrent.Await
import scala.concurrent.duration._


class MainSpec extends IntegrationSpec {

  private val timeout: FiniteDuration = 50000.milliseconds


  "Visiting Google address" should "return a 200 OK response" in {
    WsTestClient.withClient { client =>
      val result = Await.result(
        new SDILActions(client).call(), 10.seconds)
      result.statusText shouldBe "OK"
      result.status shouldBe 200
    }
  }

  "DES stub" should "return a true response" in {
    WsTestClient.withClient { client =>
      val result = Await.result(
        new SDILActions(client).postDesStub(), timeout)
      result shouldBe "true"
      println(result)
    }
  }

}

