package com.javarush.task.task37.task3707;

import sun.misc.SharedSecrets;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
//        map.putAll(collection,PRESENT);
        for (E e : collection) {
            map.put(e, PRESENT);
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(map.size());
        oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        for (E e : map.keySet())
            oos.writeObject(e);
    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        int size = ois.readInt();

        float loadFactor = ois.readFloat();

        int capacity = ois.readInt();

        map = new HashMap<>(capacity, loadFactor);
        
        for (int i=0; i<size; i++) {
            @SuppressWarnings("unchecked")
            E e = (E) ois.readObject();
            map.put(e, PRESENT);
        }
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    @Override
    public boolean add(Object o) {
        return null == map.put((E) o, PRESENT);
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
//    @Override
//    public boolean addAll(Collection c) {
//
//        boolean b = null == map.putAll((E) c, PRESENT);
//        return b;
//    }
}
