package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/Users/alexp/Desktop/JavaRushTasks/file1.txt");
            InputStream inputStream = new FileInputStream("/Users/alexp/Desktop/JavaRushTasks/file1.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println("   x : " + ivanov.equals(somePerson));
            System.out.println(somePerson.name);
            System.out.println(somePerson.assets.get(1).getPrice());
            System.out.println(somePerson.hashCode());
            System.out.println(ivanov.hashCode());
            System.out.println(ivanov.assets.get(1).getPrice());

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
//            System.out.println(name.hashCode()+"x");
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(outputStream));
            write.write(this.name); write.newLine();
            if (this.assets.size() > 0) {
                for (Asset current : this.assets){
                    write.write(current.getName());
                write.newLine();
                }
            }
            write.close();
            for (Asset a:assets  ) {
                System.out.println(a.getName());
            }
            System.out.println(assets.size());
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();
            String assetName;
            while ((assetName = reader.readLine()) != null) {
                this.assets.add(new Asset(assetName));

            }
            reader.close();
            for (Asset a:assets  ) {
                System.out.println(a.getName());
            }
            System.out.println(assets.size());
        }
    }
}
