package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import securesocial.core.java.SecureSocial;
import views.html.index;

public class Application extends Controller {

    @SecureSocial.SecuredAction
    public static Result index() {
        return ok(index.render());
    }


    @SecureSocial.SecuredAction
    public static Result secured() {
        return ok(index.render());
    }
}
