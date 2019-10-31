//package com.javarush.task.task28.task2810.model;
//
//import com.javarush.task.task28.task2810.vo.Vacancy;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Collections;
//import java.util.List;
//
//public class DiceStrategy implements Strategy{
//    private static final String URL_FORMAT = "https://www.dice.com/jobs?q=java+jun&l=%s&p=%d";
//
//    @Override
//    public List<Vacancy> getVacancies(String searchString) {
//        Connection connection = Jsoup.connect(String.format(URL_FORMAT,"",1));
//        connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
//        connection.referrer("www.google.com");
//        Document document;
//        try {
//            document = connection.get();
//            System.out.println(document.html());
//            Files.write(Paths.get("/Users/alexp/Desktop/JavaRushTasks/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task28/task2810/html"), Collections.singleton(document.html()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return Collections.EMPTY_LIST;
//    }
//}
