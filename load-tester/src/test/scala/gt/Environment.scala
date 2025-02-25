package gt

import scala.concurrent.duration._

object Environment {

    def envOrElse(name: String, alt: String): String = Option(System.getenv(name))
        .orElse(Option(System.getProperty(name)))
        .getOrElse(alt)

    val profile: String = envOrElse("profile", "local")
    val rampUpTime: FiniteDuration = envOrElse("rampUpTIme", "10").toInt seconds
    val maxUsers: Int = envOrElse("users", "10000").toInt

    var baseUrl: String = ""
    var publicHomePage: String = ""

    if (profile == "local") {
        baseUrl = "http://localhost:8081"
        publicHomePage = "/"
    }
}
