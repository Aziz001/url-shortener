
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/aziz/Desktop/url-shortener/conf/routes
// @DATE:Thu Jan 26 19:13:21 CET 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAPIController APIController = new controllers.ReverseAPIController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAPIController APIController = new controllers.javascript.ReverseAPIController(RoutesPrefix.byNamePrefix());
  }

}
