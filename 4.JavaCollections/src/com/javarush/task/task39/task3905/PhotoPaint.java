package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public Color defColor;

    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (y<0||y>image.length-1) return false;
        if (x<0||x>image[0].length-1) return false;
        if (image[y][x]==desiredColor) return false;
        if (defColor == null) defColor = image[y][x];
        if (image[y][x]!=defColor) return false;

        System.out.println(x+":"+y);

        image[y][x]=desiredColor;
        paintFill(image,x-1,y,desiredColor);
        paintFill(image,x+1,y,desiredColor);
        paintFill(image,x,y-1,desiredColor);
        paintFill(image,x,y+1,desiredColor);
        paintFill(image,x-1,y-1,desiredColor);
        paintFill(image,x+1,y+1,desiredColor);
        paintFill(image,x+1,y-1,desiredColor);
        paintFill(image,x-1,y+1,desiredColor);
        return true;
    }
}
