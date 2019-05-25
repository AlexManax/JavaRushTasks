package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution <T> {

    public static void main(String[] args) {
        HashMap<Object, Number> map = newHashMap(newArrayList("first", "second"), newArrayList(1,2));
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(elements));
        return arrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet hashSet = new HashSet(Arrays.asList(elements));
        return hashSet;
    }

    public static <K, V> HashMap <K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size()!=values.size()) throw new IllegalArgumentException();

        HashMap<K, V> resultMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            resultMap.put(keys.get(i), values.get(i));
        }
        return resultMap;
    }
}
