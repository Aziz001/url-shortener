
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/aziz/Desktop/url-shortener/conf/routes
// @DATE:Thu Jan 26 19:13:21 CET 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
