package com.javarush.task.task37.task3711;

public class Computer {
    CPU cpu = new CPU();
    Memory memory = new Memory();
    HardDrive hdd = new HardDrive();

    public void run(){
        cpu.calculate();
        memory.allocate();
        hdd.storeData();
    }
}
