package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] x = new Solution[2];
        x[0] = new Solution();
        x[1] = new Solution();
        x[0].innerClasses[0] = x[0].new InnerClass();
        x[0].innerClasses[1] = x[0].new InnerClass();
        x[1].innerClasses[0] = x[1].new InnerClass();
        x[1].innerClasses[1] = x[1].new InnerClass();
        return x;
    }

    public static void main(String[] args) {

    }
}
