
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/aziz/Desktop/url-shortener/conf/routes
// @DATE:Thu Jan 26 19:13:21 CET 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  APIController_1: controllers.APIController,
  // @LINE:4
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    APIController_1: controllers.APIController,
    // @LINE:4
    Assets_0: controllers.Assets
  ) = this(errorHandler, APIController_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, APIController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shorten""", """controllers.APIController.shorten()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """token<.+>""", """controllers.APIController.getUrl(token:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_APIController_shorten0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shorten")))
  )
  private[this] lazy val controllers_APIController_shorten0_invoker = createInvoker(
    APIController_1.shorten(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.APIController",
      "shorten",
      Nil,
      "POST",
      """ Routes""",
      this.prefix + """shorten"""
    )
  )

  // @LINE:3
  private[this] lazy val controllers_APIController_getUrl1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("token", """.+""",false)))
  )
  private[this] lazy val controllers_APIController_getUrl1_invoker = createInvoker(
    APIController_1.getUrl(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.APIController",
      "getUrl",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """""" + "$" + """token<.+>"""
    )
  )

  // @LINE:4
  private[this] lazy val controllers_Assets_versioned2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_APIController_shorten0_route(params) =>
      call { 
        controllers_APIController_shorten0_invoker.call(APIController_1.shorten())
      }
  
    // @LINE:3
    case controllers_APIController_getUrl1_route(params) =>
      call(params.fromPath[String]("token", None)) { (token) =>
        controllers_APIController_getUrl1_invoker.call(APIController_1.getUrl(token))
      }
  
    // @LINE:4
    case controllers_Assets_versioned2_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
