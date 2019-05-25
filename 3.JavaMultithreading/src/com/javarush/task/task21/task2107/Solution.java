package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.users.equals(clone.users));
            System.out.println(solution.users.values().equals(clone.users.values()));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }

    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        if (users==solution.users) return false;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {

        return (int)(Math.random()*9999);
    }

    public static class User implements Cloneable{
        int age;
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof User)) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for (Map.Entry<String,User> map:this.users.entrySet()){
            User userOriginal = map.getValue();
            User userClone = new User(userOriginal.age,userOriginal.name);
            solution.users.put(map.getKey(),userClone);
        }
        return solution;
    }
}
