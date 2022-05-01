

import dao.Sql2oHeroDao;
import dao.SquadDao;
import models.Hero;
import models.Squad;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/herosquad.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);

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
        get( "/squad/new", (request, response) -> {
            Map<String, Object>  model= new HashMap <String,Object>();
            return new ModelAndView( new HashMap (), "squadform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power=request.queryParams("power");
            String weakness=request.queryParams("weakness");
//            String squad=request.queryParams("squad");
            int squad = Integer.parseInt(request.queryParams("squad"));
            Hero heroes = new Hero(name, age, power,weakness,squad);
            model.put("heroes", heroes);
            return new ModelAndView(model, "herosuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = Hero.getAllInstances();
            model.put("heroes", heroes);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual hero
        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params("id"));
            Hero foundHero = Hero.findById(idOfHeroToFind);
            model.put("hero", foundHero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());



        //get: delete all heroes

        get("/heroes/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(request.params("id"));
            Hero deleteTask = Hero.findById(idOfHeroToDelete);
            deleteTask.deleteHero();
            model.put("heroes",Hero.getAllInstances());
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());


        post("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squadName = request.queryParams("squadName");
            String cause =request.queryParams("cause");
            int size = Integer.parseInt(request.queryParams("size"));
            Squad squad = new Squad(squadName, cause, size);
            model.put("squad", squad);
            return new ModelAndView(model, "squadsuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squad", Squad.getAllInstances());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


    }
}