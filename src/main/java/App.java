

import dao.Sql2oHeroDao;
import dao.SquadDao;
import models.Hero;
import models.Squad;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    private static SquadDao squadDao;

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
            Map<String, Object> model = new HashMap<>();
            // TODO replace test data with ones from the DB
            ArrayList<Squad> squad = Squad.getSquadInstances();
            model.put("squad", squad);
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());

        //squad form
        get( "/squad/new", (request, response) -> {
            Map<String, Object>  model= new HashMap <String,Object>();
            return new ModelAndView( new HashMap (), "squadform.hbs");
        }, new HandlebarsTemplateEngine());



        post("/heroes", (request, response) -> {
            String name = request.queryParams("name");
            int age=Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            String squadName = request.queryParams("squadName");
            System.out.println(request.queryParams());
            Hero heroes = new Hero(name, age, power, weakness, squadName);
            // TODO save to DB
            System.out.println(heroes);
            return new ModelAndView(new HashMap<>(), "herosuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            // TODO replace this with values from the DB
            ArrayList<Hero> heroes = Hero.getAllInstances();
            for(Hero h : heroes) {
                Squad squad = Squad.findById(h.getSquadId());
                h.setSquad(squad);
            }
            model.put("heroes", heroes);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        // get: show an individual hero
//        get("/heroes/:id", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfHeroToFind = Integer.parseInt(request.params("id"));
//            // TODO replace this with values from the DB
//            Hero foundHero = Hero.findById(idOfHeroToFind);
//            model.put("hero", foundHero);
//            return new ModelAndView(model, "hero-detail.hbs");
//        }, new HandlebarsTemplateEngine());
//
//         get: delete all heroes
        get("/heroes/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            // TODO replace this with values from the DB
            Hero.clearAllHeroes();
            model.put("heroes", Hero.getAllInstances());
            return new ModelAndView(model,"hero-detail.hbs");
        }, new HandlebarsTemplateEngine());



        post("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("squadName");
            String cause = request.queryParams("cause");
            int size=Integer.parseInt(request.queryParams("size"));
            Squad newSquad = new Squad(name, cause, size);
            model.put("squad", newSquad);
            // TODO: save to DB
            return new ModelAndView(model, "squadsuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            // TODO: get squads from DB and return them
            model.put("squad", Squad.getSquadInstances());
            return new ModelAndView(model, "squad-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squad.clearAllSquads();
            // TODO get values from DB
            ArrayList<Hero> heroes = Hero.getAllInstances();
            for(int i = 0; i < heroes.size(); i++) {
                heroes.get(i).updateHeroStatus(false);
            }
            model.put("squad", Squad.getSquadInstances());
            return new ModelAndView(model,"squad-detail.hbs");
        },new HandlebarsTemplateEngine());

        get("/squad/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind = Integer.parseInt(request.params(":id"));
            // TODO get values from DB
            Squad foundSquad = Squad.findById(idOfSquadToFind);
            model.put("squad", foundSquad);
            ArrayList<Squad> squad = Squad.getSquadInstances();
            model.put("squad",squad);
            return new ModelAndView(model,"squad-detail.hbs");
        },new HandlebarsTemplateEngine());









    }
}