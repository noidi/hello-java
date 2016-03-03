package fi.solita.cd;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class Hello
{

    public static void main(String[] args)
    {
        List<Message> ms = new ArrayList<>();
        ms.add(new Message("foo"));
        ms.add(new Message("bar"));
        ms.add(new Message("baz"));
        MainPage p = new MainPage(readBuild(), ms);
        get("/", (req, res) -> new ModelAndView(p, "hello.mustache"),
            new MustacheTemplateEngine());
    }

    private static String readBuild() {
        try (Scanner s = new Scanner(Hello.class.getResourceAsStream("/build.txt"))) {
            return s.next();
        }
    }

}
