package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HHStrategy implements Strategy {
        private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
//    private static final String URL_FORMAT = "https://javarush.ua/testdata/big28data.html";


    protected Document getDocument(String searchString, int page) throws IOException {
        Document document = null;
        String url = String.format("%s?text=%s&page=%s",URL_FORMAT, searchString, page);

        try {
        Connection connection = Jsoup.connect(String.format(URL_FORMAT,searchString,page))
//            Connection connection = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                    .referrer("https://www.google.ru/")
                    .timeout(5000);
            document = connection.get();
//            System.out.println(document);
        } catch (Exception e) {
            System.out.println(e);
        }
        return document;
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        Document document = null;
        List<Document> documentList = new ArrayList<>();
        String title = "";
        int pNumber = 0;
        while (true) {
            try {
                if ((document = getDocument(searchString, pNumber)) != null) {
                    if(!document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy").hasText()) break;
                    documentList.add(document);
//                    System.out.println(title);
//                    System.out.println(pNumber);
                } else break;
            } catch (IOException e) {
//                e.printStackTrace();
            }
            System.out.println("HH page : " + pNumber);
            pNumber++;
        }
//        System.out.println(documentList.size());
//        System.out.println(documentList.get(0));


//        Elements elements = documentList.get(0).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

//        System.out.println("------------------");
//            System.out.println(elements.first());
//            System.out.println(documentList.size());
        for (Document doc : documentList) {
            Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            title = doc.title();
            for (Element element : elements) {
                vacancies.add(getPosition(element, title));
//            System.out.println(document.title());
            }
        }
        return vacancies;
    }

    private Vacancy getPosition(Element element, String title) {
        Vacancy vacancy = new Vacancy();
//        System.out.println(  (element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title")).text()  );
        vacancy.setTitle((element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title")).text());
//        System.out.println(  (element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title")).attr("href")  );
        vacancy.setUrl((element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title")).attr("href"));
//        System.out.println(  (element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address")).text()  );
        vacancy.setCity((element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address")).text());
//        System.out.println(  (element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer")).text()  );
        vacancy.setCompanyName((element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer")).text());
//        System.out.println(  (element.getElementsByClass("searchresult__name")).eachText() );
        vacancy.setSiteName("http://hh.ua");

        Element salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").first();
        vacancy.setSalary(salary != null ? salary.text() : "");

        return vacancy;
    }
}
