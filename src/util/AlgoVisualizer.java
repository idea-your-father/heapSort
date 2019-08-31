package util;

import day1.Main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.LinkedList;

/**
 * Created by ASUS on 2019/8/22.
 */
public class AlgoVisualizer {
    //TODO: 具体传入的数据
    private int delayTime = 100;
    private AlgoFrame frame;
    private SelectionSortData data;



    public AlgoVisualizer(int sWidth,int sHeight,int N) {
        //TODO: 动画初始化
        data = new SelectionSortData(N,sHeight);




        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("堆排序",sWidth,sHeight);




            new Thread(()->{
                run();

            }).start();



        });




    }
    //TODO: 具体动画逻辑
    //动画逻辑
    private void run() {
        setData(-1,-1);
        //建堆
        for (int i=(data.N()-1-1)/2;i>=0;i--)
        {
            shiftDown(data.numbers,data.N(),i);
        }
        //堆排序
        for (int i=data.N()-1;i>0;i--) {
            data.swap(0,i);
            data.lastSwap = i;
            shiftDown(data.numbers,i,0);
            data.fixedPivots[i]=true;
        }
        setData(-1,-1);



    }


    private void setData(int father,int son){
        data.father=father;
        data.son=son;
        frame.render(data);
        AlgoVisHelper.pause(delayTime);



    }













    public void swap(int[] arr,int l,int r)
    {
        if(arr[l]==arr[r])return;
        arr[l]^=arr[r];
        arr[r]^=arr[l];
        arr[l]^=arr[r];
    }


    public void HeapSort(int[]arr) {
        int N = arr.length;

        for(int i=(N-1)/2;i>=0;i--)
        {
            shiftDown(arr,N,i);
        }
        for(int i=arr.length-1;i>0;i--)
        {
            swap(arr,0,i);
            shiftDown(arr,i,0);

        }



    }

   void shiftDown(int[] arr,int heapSize,int i)
    {
        setData(i,-1);
        while (leftChild(i)<heapSize)
        {
            int j=leftChild(i);
            setData(i,j);
            if(rightChild(i)<heapSize&&arr[rightChild(i)]>arr[j])
            {
                j+=1;//j=rightChild(i),选择左孩子还是选择右孩子，看哪个更强
                setData(i,j);
            }
            if(arr[i]>=arr[j])
            {
                break;
            }
            swap(arr,i,j);
            setData(i,j);
            i=j;
            setData(i,-1);
        }

    }



   int parent(int i)
    {
        return (i-1)/2;
    }
     int leftChild(int i)
    {
        return 2*i+1;
    }
     int rightChild(int i)
    {
        return 2*i+2;
    }
     int lastNodeForHeapify(int N)
    {
        return (N-1)/2;
    }






}


