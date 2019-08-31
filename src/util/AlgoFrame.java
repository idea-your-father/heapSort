package util;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

/**
 * Created by ASUS on 2019/8/22.
 */
public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;




    public AlgoFrame(String title,int canvasWidth,int canvasHeight) throws HeadlessException {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        //把canvas设置 为主要的内容面板
        this.setContentPane(canvas);
        //根据加载内容 自动布局整理
        pack();






        setSize(getCanvasWidth()+10,getCanvasHeight()+50);
        setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);


    }

    public AlgoFrame(String title) {
        this(title,1024,1024);
    }




    /**
     *
     * 内部类
     * canvas 画布
     *
     * */
    private class AlgoCanvas extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;
            //抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);


           //具体绘制
            //TODO:绘制自己的图形
            /*
            *
            * 绘制图形
            *
            *
            * */



            int w = canvasWidth/data.N();
            for(int i=0;i<data.numbers.length;++i) {

                if(data.fixedPivots[i])
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.LightGreen);
                else if(i==data.lastSwap)
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Brown);
                else
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Grey);
                if(i==data.father)
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.LightBlue);
                if(i==data.son)
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Red);


                AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight - data.get(i), w - 1, data.get(i));
            }





        }

        /**
         *返回 屏幕大小
         *
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
    /*
    *
    * 如何使用 graphics2d
    *
    * */



    /*
    *
    * 画图
    * */
    //TODO: 设置自己的数据
    // private Object data;

    private SelectionSortData data;
    public void render(SelectionSortData data){

        this.data = data;
        if(data!=null) {
            repaint();
        }
    }





    static void swap(int [] arr,int l,int r)
    {
        int t = arr[l];
        arr[l]=arr[r];
        arr[r]=t;
    }






    /**
     *
     * 普通方法
     *
     *
     * */

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth-60;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight-60;
    }















}
