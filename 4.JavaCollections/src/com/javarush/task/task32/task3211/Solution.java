package com.javarush.task.task32.task3211;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.javarush.task.task32.task3208.Cat;


import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


/* 
Целостность информации
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, pets);
        System.out.println(writer.toString());
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Cat.class, name = "Cat"),
            @JsonSubTypes.Type(value = Dog.class, name = "Dog")
    })
    static class Pet {
        public String name;
        public List<Pet> pets = new ArrayList();
    }

    static class Cat extends Pet {
        public int age;
    }

    static class Dog extends Pet {
        public int age;
        public String owner;
    }

    static class House {
        public List<Pet> pets = new ArrayList<>();
    }
}