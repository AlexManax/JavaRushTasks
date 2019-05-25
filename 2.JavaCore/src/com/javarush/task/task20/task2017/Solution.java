package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        Solution.A x = null;
        try {
            Object z = objectStream.readObject();
            if (z instanceof A) {
                x = (Solution.A) z;
            } else return null;
        } catch (IOException | ClassNotFoundException ignored) {
        } catch (Exception e){return null;}
        return x;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
