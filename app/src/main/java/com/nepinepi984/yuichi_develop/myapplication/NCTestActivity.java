package com.nepinepi984.yuichi_develop.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonObject;
import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.FetchCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

import java.util.LinkedHashMap;

public class NCTestActivity extends AppCompatActivity {

  private static final String TAG = "NCTest";
  private static final String ERROR = "NC_ERROR";
  private static final String APP_KEY = "e66a3e0ad2e676d0f20cd9a61a97b9f74681e0586bc6855a25ef76e29fa2ef86";
  private static final String CLIENT_KEY = "d129670b18f19e98025854818933bf14c195fcd57cdc9adfddf8d34fd6689d28";
  private static final String CALL = "call";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nctest);

    // APIキーの設定とSDK初期化
    NCMB.initialize(this.getApplicationContext(), APP_KEY, CLIENT_KEY);
    // ↓　ここにサンプルコードを実装　↓
    // クラスのNCMBObjectを作成
    final NCMBObject obj = new NCMBObject("NCTest");
    try {
      obj.setObjectId("3CiigC6bmaqPO52i");
    } catch (NCMBException e) {
      e.printStackTrace();
    }
    obj.fetchInBackground(new FetchCallback<NCMBObject>() {
      @Override
      public void done(NCMBObject object, NCMBException e) {
        if (e != null) {
          //エラー時の処理
          Log.d(ERROR, "error!");
        } else {
          //取得成功時の処理
          Log.d(TAG, "done: " + object.toString());
          Log.d(CALL, String.valueOf(object.getJSONObject("mFields")));
          LinkedHashMap<String, String> tempHashMap = new LinkedHashMap<>();
          Log.d(CALL, object.getString("name")); // "Yuichi" Output!
        }
      }
    });
  }
}
