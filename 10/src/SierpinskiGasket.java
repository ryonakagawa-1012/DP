/*
name : SierpinskiGasket.java
about : 第10講 練習問題10-08 シェルピンスキーのギャスケット
        https://ksuap.github.io/2022autumn/lesson10/assignments/#8-シェルピンスキーのギャスケット
date : 2023_Jul13,16
coder : name : 武藤 太央 (Muto Tao)
        studentID : 254739
*/


import java.util.ArrayList;     // ArrayListを利用するためにimport
import java.io.*;       // 画像ファイルへの書き込みを行うためにimport

import java.awt.Graphics2D;     // Graphics2Dを利用するためにimport
import java.awt.geom.Line2D;        // Line2D.Doubleを利用するためにimport
import java.awt.image.BufferedImage;        // BufferedImageを用いるためにimport
import java.awt.Color;      // 色の設定を行うためにimport

import javax.imageio.ImageIO;       // 画像ファイルを作成するためにimoprt


public class SierpinskiGasket {
    BufferedImage image =  new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = image.createGraphics();      // 描画器を取得する。


    void run(String[] args) throws IOException {
        setupuImage();      // 出力画像の初期設定を行う。具体的には、背景色を白にする。
        ArrayList<Point> vertexes = new ArrayList<>();      // 三角形たちの頂点の座標を保存するためのArrayList
        vertexes = setup(vertexes);     // 最初の三角形の頂点の座標を設定する。
        Integer n = setupTimes(args);        // 三角形の描画回数を定める変数を設定する。

        g.setColor(Color.BLACK);      // 線の色を設定する。
        drawTriangle(vertexes.get(0), vertexes.get(1), vertexes.get(2));        // 最初の三角形を描画する。
        writeTimes(n);      // 描画を何回層分行ったかを画像に記入する。
        g.setColor(Color.RED);      // 線の色を赤にする。
        drawGasket(vertexes.get(0), vertexes.get(1), vertexes.get(2), n);       // シェルピンスキーのギャスケットを、コマンドライン引数で定められた階層分描画する。
    }


    Integer setupTimes(String[] args) {        // 三角形の描画を何回層分繰り返すかを設定するメソッド
        Integer n;

        if(args.length != 0){        // コマンドライン引数が与えられていれば
            n = Integer.valueOf(args[0]);       // コマンドライン引数で与えられている数を描画数とする。
        }else{      // コマンドライン引数が与えられていなければ
            n = 3;      // 描画数を3とする。
        }

        return n;
    }


    void setupuImage() throws IOException {     // 出力画像の初期設定を行うためのメソッド。具体的には、背景色を白にする。
        int rgb = new Color(255, 255, 255).getRGB();      // 白のRGB値を設定

        for(Integer x = 0; x < 400; x++) {      // 1ピクセルずつ白色にしていく。
                for(Integer y = 0; y < 400; y++) {
                    image.setRGB(x, y, rgb);
                }
        }

        ImageIO.write(image, "png", new File("SierpinskiGasket.png"));      // ファイルに書き込む。
    }


    ArrayList<Point> setup(ArrayList<Point> vertexes) {     // シェルピンスキーのギャスケットの最初の三角形の頂点の座標を設定するためのメソッド
        vertexes.add(setPoint(10.0, 380.0));        // 左下の頂点の座標を設定する。
        vertexes.add(setPoint(390.0, 380.0));       // 右下の頂点の座標を設定する。
        vertexes.add(setPoint(200.0, 70.9103465619));       // 上の頂点の座標を設定する。

        return vertexes;
    }


    Point setPoint(Double x, Double y){        // 二つのDouble型の値を受け取り、それらをPoint型変数に格納して返すメソッド
        Point point = new Point();

        point.x = x;        // x座標を代入
        point.y = y;        // y座標を代入

        return point;
    }


    Point midpoint(Point p1, Point p2) {        // 二つの点の中点の座標を返すメソッド
        Point mid = new Point();

        mid.x = (p1.x + p2.x)/2;        // x座標を算出
        mid.y = (p1.y + p2.y)/2;        // y座標を算出

        return mid;
    }


    void drawTriangle(Point p1, Point p2, Point p3) throws IOException {       // 引数で与えられた3つの点を結ぶ三角形を描画するメソッド
        g.draw(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));      // 底辺を描画する。
        g.draw(new Line2D.Double(p3.x, p3.y, p2.x, p2.y));      // 右の辺を描画する。
        g.draw(new Line2D.Double(p1.x, p1.y, p3.x, p3.y));      // 左の辺を描画する。

        ImageIO.write(image, "png", new File("SierpinskiGasket.png"));      // ファイルに書き込む。
    }


    void drawGasket(Point p1, Point p2, Point p3, Integer n) throws IOException {     // 引数で指定された三角形の内部に、シェルピンスキーのギャスケットをコマンドライン引数で定められた階層分描画するメソッド
        if(n == 0){     // もしnが0なら、何もしない。
            // 何もしない
        }else{      // nが0でなければ、描画を行う
            Point mid1 = midpoint(p1, p2);      // 底辺の中点を求める。
            Point mid2 = midpoint(p3, p2);      // 右の辺の中点を求める。
            Point mid3 = midpoint(p1, p3);      // 左の辺の中点を求める。

            drawTriangle(mid1, mid2, mid3);     // 引数で指定された三角形に、その3辺の中点で内接する三角形を描画する。

            drawGasket(p1, mid1, mid3, n - 1);        // 引数で指定された三角形にその3辺の中点で内接する三角形を描画することでできた小さな三角形のうち、左下の三角形を次の指定する三角形として処理を行う。
            drawGasket(mid1, p2, mid2, n - 1);        // 引数で指定された三角形にその3辺の中点で内接する三角形を描画することでできた小さな三角形のうち、右下の三角形を次の指定する三角形として処理を行う。
            drawGasket(mid3, p3, mid2, n - 1);        // 引数で指定された三角形にその3辺の中点で内接する三角形を描画することでできた小さな三角形のうち、上の三角形を次の指定する三角形として処理を行う。
        }
    }


    void writeTimes(Integer n) throws IOException {     // 描画を何回層分行ったかを画像に記入するメソッド
        String times = "n = ";
        times = times + n.toString();       // 描画数を含んだ文字列を作成する。

        g.drawString(times, 200, 50);     // 記入する。

        ImageIO.write(image, "png", new File("SierpinskiGasket.png"));      // ファイルに書き込む。
    }
    

    public static void main(String[] args) throws IOException {
        SierpinskiGasket sg = new SierpinskiGasket();
        sg.run(args);
    }
}
