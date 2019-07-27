package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class Features extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);
        tv1=(TextView)findViewById(R.id.features);
        tv2=(TextView)findViewById(R.id.feature1);
        tv3=(TextView)findViewById(R.id.feature2);
        tv4=(TextView)findViewById(R.id.feature3);
        tv5=(TextView)findViewById(R.id.feature4);
        tv6=(TextView)findViewById(R.id.feature5);
    }
}
