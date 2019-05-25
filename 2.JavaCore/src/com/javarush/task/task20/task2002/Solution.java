package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("/Users/alexp/Desktop/JavaRushTasks/file1.txt", null);
            OutputStream outputStream = new FileOutputStream("/Users/alexp/Desktop/JavaRushTasks/file1.txt");
            InputStream inputStream = new FileInputStream("/Users/alexp/Desktop/JavaRushTasks/file1.txt");

            JavaRush javaRush = new JavaRush();



            for (int i = 0; i < 10000; i++) {

                javaRush.users.add(new User());
                javaRush.users.get(i).setFirstName("Alex");
                javaRush.users.get(i).setLastName("P");
                javaRush.users.get(i).setCountry(User.Country.RUSSIA);

                javaRush.users.get(i).setBirthDate(new Date(95, 8, 29));
                javaRush.users.get(i).setMale(true);
            }
//            Thread.sleep(10);
//
//            javaRush.users.get(1).setFirstName("Alexxxxxxxxxx");
//            javaRush.users.get(1).setLastName("P2");
//            javaRush.users.get(1).setCountry(User.Country.UKRAINE);
//
//            Thread.sleep(10);
//
//            javaRush.users.get(1).setBirthDate(new Date(95, 8, 29));
//            javaRush.users.get(1).setMale(true);
//
//            Thread.sleep(10);
//
//            javaRush.users.get(2).setFirstName("xxx");
//            javaRush.users.get(2).setBirthDate(new Date(95, 8, 29));

//            System.out.println(javaRush.users.get(0).getBirthDate().getTime());
//            System.out.println(javaRush.users.get(1).getBirthDate().getTime());
//            System.out.println(javaRush.users.get(2).getBirthDate().getTime());
//            System.out.println();

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User u : loadedObject.users) {
                System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getCountry() + " " + u.getBirthDate());
            }
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }
    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(this.users.size() + "");
            writer.newLine();
            for (int i = 0; i < this.users.size(); i++) {
                if (this.users.get(i).getFirstName() != null) {
                    writer.write("1" + this.users.get(i).getFirstName());
                    writer.newLine();
                }
                if (this.users.get(i).getLastName() != null) {
                    writer.write("2" + this.users.get(i).getLastName());
                    writer.newLine();
                }
                if (this.users.get(i).getCountry() != null) {
                    writer.write("3" + this.users.get(i).getCountry().toString());
                    writer.newLine();
                }
                if (this.users.get(i).getBirthDate() != null) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");   // ормат в который  будет переводить строку
//                    String str = sdf.format(this.users.get(i).getBirthDate());   //  в строку str записываем запарсиную по формату дату
//                    writer.write("4" + str);


                    writer.write("4" + this.users.get(i).getBirthDate().getTime());
                    writer.newLine();
                }
                writer.write(String.valueOf("5" + this.users.get(i).isMale())); /*if (i != this.users.size()-1) */
                writer.newLine();
                writer.write("*******************************************");
                writer.newLine();
            }
            writer.close();
        }
        public void load(InputStream inputStream) throws Exception {
            BufferedReader rr = new BufferedReader(new InputStreamReader(inputStream));
            boolean isReady = false;
            String tmp = "";
            Date date = new Date();
            int repeats = Integer.parseInt(rr.readLine());
            ArrayList<User> x = new ArrayList<>();
            for (int i = 0; i < repeats; i++) {
                x.add(new User());
            }
            if (rr.ready()) isReady = true;
            for (int i = 0; i < repeats; i++) {
                while (rr.ready()) {
                    tmp = rr.readLine();
//                    System.out.println(tmp);
                    if (tmp.equals("*******************************************")) break;
                    switch (Integer.parseInt(tmp.substring(0, 1))) {
                        case 1:
                            x.get(i).setFirstName(tmp.substring(1));

                            break;
                        case 2:
                            x.get(i).setLastName(tmp.substring(1));
                            break;
                        case 3:
                            x.get(i).setCountry(tmp.substring(1).equals("RUSSIA") ? User.Country.RUSSIA : tmp.substring(1).equals("UKRAINE") ? User.Country.UKRAINE : User.Country.OTHER);
                            break;
                        case 4:
//                            SimpleDateFormat fd = new SimpleDateFormat("dd MM yyyy");
//                            Date birthday = fd.parse(tmp.substring(1));



                            date.setTime(Long.parseLong(tmp.substring(1)));
                            x.get(i).setBirthDate(date);
                            break;
                        case 5:
                            x.get(i).setMale(Boolean.valueOf(tmp.substring(1)));
                            break;
                    }
                }
                this.users.add(x.get(i));
                System.out.println(x.get(i).getFirstName());
            }
            rr.close();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JavaRush javaRush = (JavaRush) o;
            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }
        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
