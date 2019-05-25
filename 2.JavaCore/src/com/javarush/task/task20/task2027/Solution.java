package com.javarush.task.task20.task2027;

import java.awt.*;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    static int[][] crossword;


    public static void main(String[] args) {

        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        Solution.crossword = crossword;

        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        Point point;
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                if (words[0].charAt(0) == crossword[i][j]) {


                }
            }
        }


        return null;
    }

    private Point searchHorisontaly_LeftToRight(Point p, String word) {
        Point endPoint = new Point(0, p.y);
        if (p.x + word.length() > crossword[p.y].length) return null;

        for (int x0 = 0; x0 < word.length(); x0++) {
            char wordChar = word.charAt(x0);
            char crosswordChar = (char) crossword[p.y][p.x + x0];
            if (wordChar == crosswordChar) endPoint.x = p.x + x0;
            else return null;
        }
        return endPoint;
    }

    private Point searchHorisontaly_RightToLeft(Point p, String word) {
        Point endPoint = new Point(0, p.y);
        if (p.x - word.length() < 0) return null;

        for (int x0 = word.length() - 1; x0 >= 0; x0--) {
            char wordChar = word.charAt(x0);
            char crosswordChar = (char) crossword[p.y][p.x + x0];
            if (wordChar == crosswordChar) endPoint.x = p.x + x0;
            else return null;
        }
        return endPoint;
    }

    private Point searchVertical_UpToDown(Point p, String word) {
        Point endPoint = new Point(p.x, 0);
        if (p.y + word.length() > crossword.length) return null;

        for (int y0 = 0; y0 < word.length(); y0++) {
            char wordChar = word.charAt(y0);
            char crosswordChar = (char) crossword[p.y + y0][p.x];
            if (wordChar == crosswordChar) endPoint.y = p.y + y0;
            else return null;
        }
        return endPoint;
    }

    private Point searchVertical_DownToUp(Point p, String word) {
        Point endPoint = new Point(p.x, 0);
        if (p.y - word.length() < 0) return null;

        for (int y0 = word.length() - 1; y0 >= 0; y0--) {
            char wordChar = word.charAt(y0);
            char crosswordChar = (char) crossword[p.y + y0][p.x];
            if (wordChar == crosswordChar) endPoint.y = p.y + y0;
            else return null;
        }
        return endPoint;
    }

    private Point searchDiagonal_UpLToDownR(Point p, String word) {
        Point endPoint = new Point(0, 0);
        if (p.x + word.length() > crossword[p.y].length) return null;
        if (p.y + word.length() > crossword.length) return null;

        for (int x0 = 0; x0 < word.length(); x0++) {

                char wordChar = word.charAt(x0);
                char crosswordChar = (char) crossword[p.y + x0][p.x + x0];

                if (wordChar == crosswordChar) {
                    endPoint.x = p.x + x0;
                    endPoint.y = p.y + x0;
                } else return null;

        }
        return endPoint;
    }

    private Point searchDiagonal_DownRToUpL(Point p, String word) {
        Point endPoint = new Point(0, 0);
        if (p.x - word.length() < 0) return null;
        if (p.y - word.length() < 0) return null;

        for (int x0 = word.length() - 1; x0 >= 0; x0--) {
            for (int y0 = word.length() - 1; y0 >= 0; y0--) {
                char wordChar = word.charAt(y0);
                char crosswordChar = (char) crossword[p.y + y0][p.x + x0];

                if (wordChar == crosswordChar) {
                    endPoint.x = p.x + x0;
                    endPoint.y = p.y + y0;
                } else return null;
            }
        }
        return endPoint;
    }

    private Point searchDiagonal_UpRToDownL(Point p, String word) {
        Point endPoint = new Point(0, 0);
        if (p.x - word.length() < 0) return null;
        if (p.y - word.length() < 0) return null;
        for (int x0 = word.length() - 1; x0 >= 0; x0++) {

                char wordChar = word.charAt(x0);
                char crosswordChar = (char) crossword[p.y/* + y0*/][p.x + x0];

                if (wordChar == crosswordChar) {
                    endPoint.x = p.x + x0;
                    endPoint.y = p.y; //+ y0;
                } else return null;

        }
        return endPoint;
    }

    private Point searchDiagonal_DownLtoUpR(Point p, String word) {
        Point endPoint = new Point(0, 0);
        if (p.x + word.length() > crossword[p.y].length) return null;
        if (p.y + word.length() > crossword.length) return null;

        for (int x0 = 0; x0 < word.length(); x0++) {
            for (int y0 = 0; y0 < word.length(); y0++) {
                char wordChar = word.charAt(y0);
                char crosswordChar = (char) crossword[p.y + y0][p.x + x0];

                if (wordChar == crosswordChar) {
                    endPoint.x = p.x + x0;
                    endPoint.y = p.y + y0;
                } else return null;
            }
        }
        return endPoint;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
