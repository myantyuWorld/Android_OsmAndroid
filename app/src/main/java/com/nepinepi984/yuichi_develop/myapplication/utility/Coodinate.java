package com.nepinepi984.yuichi_develop.myapplication.utility;

import static java.lang.Math.*;

/***
 * 座標クラス（計算等実施する）
 */
public class Coodinate {

  private static final Integer LONGITUDE = 0;   // 経度
  private static final Integer LATITUDE = 1;    // 緯度
  private static final Integer LEFT_TOP = 0;
  private static final Integer RIGHT_TOP = 1;
  private static final Integer RIGHT_DOWN = 2;
  private static final Integer LEFT_DOWN = 3;
  private static final double EQUATOR_RADIUS = 6378.137; // 赤道半径

  /***
   * 引数の緯度経度がタイルの4点内か否かを返す
   * @return タイル内か否か
   */
  public static boolean isTile4PointIn(double[] coodinateCenter, double[] _4point){
    // 経度がタイル内かどうか
    if (_4point[LEFT_TOP] > coodinateCenter[LONGITUDE] && _4point[LEFT_DOWN] < coodinateCenter[LONGITUDE]){
      // 緯度がタイル内かどうか
      if (_4point[LEFT_TOP] > coodinateCenter[LATITUDE] && _4point[RIGHT_DOWN] < coodinateCenter[LATITUDE]){
        return true;
      }
    }
    return false;
  }

  /***
   * 緯度経度の2地点間距離を計算する
   * @return 計算結果
   */
  public static double calsulate2PointRange(double[] coodinate1, double[] coodinate2){
    double lng1 = coodinate1[LONGITUDE] * PI / 180;
    double lat1 = coodinate1[LATITUDE] * PI / 180;

    double lng2 = coodinate2[LONGITUDE] * PI / 180;
    double lat2 = coodinate2[LATITUDE] * PI / 180;

    // 2点間の距離[km]
    return EQUATOR_RADIUS * acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lng2 - lng1));
  }


}
