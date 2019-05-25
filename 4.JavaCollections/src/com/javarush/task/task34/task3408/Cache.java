package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    public Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO should work here

//        Constructor constructor = clazz.getConstructor(key.getClass());

//        return (clazz.getTypeName()) constructor.newInstance(key.getClass();
        if (!cache.containsKey(key))
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));

        return cache.get(key);
    }

    public boolean put(V obj) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        //TODO needs to check
        Method method = null;
        try {
            method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);

            cache.put((K) method.invoke(obj), obj);
            return cache.containsKey((K) method.invoke(obj));
        }catch (Exception x){}
        return false;
    }

    public int size() {
        return cache.size();
    }
}
