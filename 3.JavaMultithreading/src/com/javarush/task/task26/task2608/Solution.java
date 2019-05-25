package com.javarush.task.task26.task2608;

/* 
Мудрый человек думает раз, прежде чем два раза сказать
*/
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;
    private Object o1;
    private Object o2;
    private Object o3;

    public Solution(int var1, int var2, int var3, int var4) {
        synchronized (o1){
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;}
    }

    public int getSumOfVar1AndVar2() {
        synchronized (o2){
        return var1 + var2;}
    }

    public int getSumOfVar3AndVar4() {
        synchronized (o3){
        return var3 + var4;}
    }

    public static void main(String[] args) {

    }
}
