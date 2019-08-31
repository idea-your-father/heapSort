package util;

import java.awt.*;

/**
 * Created by ASUS on 2019/8/22.
 */
public class Circle {

    public int x,y;
    private int r;
    // public int vx,vy;
    // public boolean isFilled=false;

    public Circle(int x, int y, int r/*, int vx, int vy*/) {
        this.x = x;
        this.y = y;
        this.r = r;

    }

    public int getR() {
        return r;
    }
    // public void move(int minx,int miny,int maxx,int maxy) {
    //     x+=vx;
    //     y+=vy;
    //     checkCollision(minx,miny,maxx,maxy);
    // }
    // private void checkCollision(int minx,int miny,int maxx,int maxy) {
    //     maxy = maxy-30;
    //     if(x-r<minx) {
    //         x=r;vx = -vx;
    //     }
    //     if(x+r>=maxx){
    //         x=maxx-r;vx=-vx;
    //     }
    //     if(y-r<miny) {
    //         y=r;vy=-vy;
    //     }
    //     if(y+r>maxy) {
    //         y=maxy-r;vy=-vy;
    //     }
    //
    //
    // }
    public boolean contain(Point p) {
        int dx = x-p.x;
        int dy = y-p.y;
        return dx*dx+dy*dy<=r*r;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setR(int r) {
        this.r = r;
    }
}
