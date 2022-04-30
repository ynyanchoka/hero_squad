import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

       //home
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(new HashMap(), "index.hbs");

        }, new HandlebarsTemplateEngine());

        //hero form
        get( "/heroes/new", (request, response) -> {
            Map<String, Object>  model= new HashMap <String,Object>();
            return new ModelAndView( new HashMap (), "heroform.hbs");
        }, new HandlebarsTemplateEngine());

        //squad form
        get( "/squads/new", (request, response) -> {
            Map<String, Object>  model= new HashMap <String,Object>();
            return new ModelAndView( new HashMap (), "squadform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power=request.queryParams("power");
            String weakness=request.queryParams("weakness");
            Hero heroes = new Hero(name, age, power,weakness);
            model.put("heroes", heroes);
            return new ModelAndView(model, "herosuccess.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power=request.queryParams("power");
            String weakness=request.queryParams("weakness");
            Hero heroes = new Hero(name, age, power,weakness);
            model.put("heroes", heroes);
            return new ModelAndView(model, "herosuccess.hbs");
        }, new HandlebarsTemplateEngine());
    }
}