//package com.javarush.task.task28.task2810.view;
//
//import com.javarush.task.task28.task2810.Controller;
//import com.javarush.task.task28.task2810.vo.Vacancy;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//
//public class HtmlView implements View {
//    //    private final String filePath = "com/javarush/task/task28/task2810/view/vacancies.html";
//    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";
//
//    private Controller controller;
//
//    @Override
//    public void update(List<Vacancy> vacancies) {
//        try {
////            System.out.println(getUpdatedFileContent(vacancies));
//            updateFile(getUpdatedFileContent(vacancies));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void setController(Controller controller) {
//        this.controller = controller;
//    }
//
//    public void userCitySelectEmulationMethod() {
//        controller.onCitySelect("Moscow");
//    }
//
//    private String getUpdatedFileContent(List<Vacancy> vacancies) {
//        Document document = null;
//        try {
//            document = getDocument();
//
//            Elements elementVacancy = document.getElementsByAttributeValue("class", "vacancy");
//            for (int i=0;i<elementVacancy.size();i++){
//                elementVacancy.get(i).remove();
//            }
//
//            Element eOrig = document.getElementsByClass("template").first();
//            Element eCopy = eOrig.clone();
//            eCopy.removeAttr("style");
//            eCopy.removeClass("template");
//
//            for (Vacancy vacancy:vacancies) {
//                Element eTemp = eCopy.clone();
//                eTemp.getElementsByClass("city").first().text(vacancy.getCity());
//                eTemp.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
//                eTemp.getElementsByClass("salary").first().text(vacancy.getSalary());
//
//                eTemp.getElementsByClass("title").first().text(vacancy.getTitle());
//                eTemp.getElementsByClass("title").first().attr("href", vacancy.getUrl());
//
//                eOrig.before(eTemp.outerHtml());
//
////                System.out.println("************************************");
////                System.out.println(eTemp);
////                System.out.println("************************************");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Some exception occurred";
//        }
//
//
//        return document.toString();
//    }
//
//    protected Document getDocument() throws IOException {
//        return Jsoup.parse(new File(filePath), "UTF-8");
//    }
//
//
//    private void updateFile(String string) {
//        try {
//            FileWriter fileWriter = new FileWriter(new File(filePath));
//            fileWriter.write(string);
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
