package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;

    public Solution(){}
private String fileName;
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(stream);
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();



//        String fileName = (String) in.readObject();
        this.stream = new FileOutputStream(fileName,true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("D:\\file.txt");
        ObjectOutputStream out = new ObjectOutputStream(solution.stream);
        solution.writeObject("Data");
        solution.writeObject(out);

//        ObjectInputStream in = new ObjectInputStream(new FileInputStream(solution));
        Solution loadSolution = new Solution("D:\\file.txt");
//        loadSolution = (Solution) in.readObject();
    }
}
