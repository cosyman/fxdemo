/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cosysoft.cg;

import javafx.geometry.Point2D;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

/**
 *
 * @author Administrator
 */
public class GraphicUtil {

  public static void drawLine(Point2D p1, Point2D p2, Color color, PixelWriter pw) {
    double k = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    double y = 0;
    for (int x = (int) p1.getX(); x <= (int) p2.getX(); x++) {
      pw.setColor(x, (int) (y + .5), color);
      y += k;
    }
  }

  static void circlePoints(Point2D center, int x, int y, Color color, PixelWriter pw) {
    pw.setColor(x, y, color);
    pw.setColor(y, x, color);
    pw.setColor((int) (center.getX() - x), y, color);
    pw.setColor(y, (int) (center.getX() - x), color);
    pw.setColor(x, (int) (center.getY() - y), color);
    pw.setColor((int) (center.getY() - y), x, color);
    pw.setColor((int) (center.getX() - x), (int) (center.getY() - y), color);
    pw.setColor((int) (center.getY() - y), (int) (center.getX() - x), color);
  }

  public static void drawCircle(Point2D center, int r, Color color, PixelWriter pw) {
    {
      int x = 0, y = r;
      double d = 1.25 - r;
      circlePoints(center, x, y, color, pw);
      while (x <= y) {
        if (d < 0) {
          d += 2 * x + 3;
        } else {
          d += 2 * (x - y) + 5;
          y--;
        }
        x++;
        circlePoints(center, x, y, color, pw);
      }
    }
  }
}
