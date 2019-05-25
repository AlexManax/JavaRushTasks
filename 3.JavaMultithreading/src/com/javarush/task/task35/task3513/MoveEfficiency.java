package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        int result = new Integer(this.numberOfEmptyTiles).compareTo(new Integer(o.numberOfEmptyTiles));
        if (result == 0) result = new Integer(this.score).compareTo(new Integer(o.score));
        return result;
    }

}
