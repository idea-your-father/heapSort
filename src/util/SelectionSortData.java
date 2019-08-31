package util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ASUS on 2019/8/29.
 */
public class SelectionSortData {
    //TODO: 辅助线设置
    public int father,son,lastSwap;







    public int[] numbers;
    public boolean[] fixedPivots;
    public int curPivot;
    public int curL,curR;

    int h;
    public SelectionSortData(int N,int randomBound) {
        numbers = new int[N];
        fixedPivots = new boolean[N];
        this.h = randomBound;

        for(int i=0;i<N;i++) {
            numbers[i] = (int) (Math.random() * randomBound) + 1;
            fixedPivots[i] = false;
        }






    }

    public int N() {
        return numbers.length;
    }
    public int get(int index)
    {
        if(index<0|| index>=numbers.length)
            return 0;
        return numbers[index];
    }

    public void swap(int i,int j) {
        if(numbers[i]==numbers[j]) return;
        numbers[i]^=numbers[j];
        numbers[j]^=numbers[i];
        numbers[i]^=numbers[j];
    }

    public void randomRange() {
        for(int i=0;i<numbers.length;i++)
        {
            numbers[i]=(int)(Math.random()*this.h)+1;
            fixedPivots[i]=false;
        }

    }



}
