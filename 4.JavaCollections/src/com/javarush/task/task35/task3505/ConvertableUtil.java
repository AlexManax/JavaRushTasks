package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static  <V, K extends Convertable<V>> Map convert(List <K> list) {
        Map result = new HashMap();
        for (K x:list) {
            result.put(x.getKey(),x);
        }
        return result;
    }
}
