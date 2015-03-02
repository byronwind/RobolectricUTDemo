package com.baidu.liguoqing.robolectricutdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by liguoqing on 3/2/15.
 */
@Config(emulateSdk = 18,manifest = "./src/main/AndroidManifest.xml",reportSdk = 18)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    private Activity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
    }

    @Test
    public void shouldNotBeNull() {
        assertThat(activity).isNotNull();
        TextView textView = (TextView) activity.findViewById(R.id.hello_txt);
        assertThat(textView).isNotNull();

        Button button = (Button) activity.findViewById(R.id.button);
        assertThat(button).isNotNull();

    }

    @Test
    public void onCreate_mainActivityText() throws Exception {
        TextView tv = (TextView)activity.findViewById(R.id.hello_txt);
        Assert.assertNotNull(tv);
        Assert.assertSame(tv.getText(), activity.getResources().getString(R.string.hello_world));
    }
}
