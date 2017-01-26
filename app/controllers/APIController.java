package controllers;

import java.util.regex.Pattern;

import javax.inject.*;
import play.*;
import play.mvc.*;
import play.data.DynamicForm;
import play.data.Form;
import services.Shortner;

import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;

import models.*;

/**
 * This controller has a {@link Singleton} annotation because we need to make
 * sure we had only one instance of the controller
 **/
@Singleton
public class APIController extends Controller {

    private final Shortner shortner;

    @Inject
    public APIController(Shortner shortner) {
        this.shortner = shortner;
    }

    /**This function takes the tiny url and it returns the original url **/
    public Result getUrl(String token) {
        ObjectNode result = Json.newObject();

        if(token == null || token.isEmpty()) {
            result.put("status", "Error");
            result.put("message", "Missing parameter [token]");
            return badRequest(result);
        }


        Url u = Url.find.byId(shortner.decode(token));
        if (u == null) {
            result.put("status", "Error");
            result.put("message", "Token not recognized!");
            return badRequest(result);
        }
        String url = u.url;
        result.put("status", "Success");
        result.put("url", url);
        return ok(result);
    }


    /**This function takes the url and it returns the tiny url **/
    public Result shorten() {
        ObjectNode result = Json.newObject();

        String url = request().body().asText();


        if(url == null || url.isEmpty())  {
            result.put("status", "Error");
            result.put("message", "Missing parameter [url]");
            return badRequest(result);
        }

        String pattern = "^((https?|ftp|http)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$";
        // "^(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!10(?:\\.\\d{1,3}){3})(?!127(?:\\.\\d{1,3}){3})(?!169\\.254(?:\\.\\d{1,3}){2})(?!192\\.168(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)*(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}]{2,})))(?::\\d{2,5})?(?:/[^\\s]*)?$_iuS";
        boolean isMatch = Pattern.matches(pattern, url);

        if (url.startsWith("http://") && ! url.startsWith("https://")) {
            url = "http://" + url;
        }

        if(!isMatch) {
            result.put("status", "Error");
            result.put("message", "You did not provide a valid url.");
            return badRequest(result);
        }

        Url u = Url.find.where().eq("url", url).findUnique();
        if (u == null) {
            u = new Url();
            u.url = url;
            Ebean.save(u);
            Ebean.endTransaction();
        }

        String key = shortner.encode(u.id);
        result.put("status", "Success");
        result.put("token", "http://localhost:9000/"+key);

        return ok(result);
    }

}
