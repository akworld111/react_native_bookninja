package com.bookingninjas;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import io.fabric.sdk.android.Fabric;
import com.facebook.react.ReactApplication;
import com.imagepicker.ImagePickerPackage;
import com.smixx.fabric.FabricPackage;
import com.azendoo.reactnativesnackbar.SnackbarPackage;
import com.hoxfon.react.RNTwilioVoice.TwilioVoicePackage;
import com.horcrux.svg.SvgPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new ImagePickerPackage(),
            new FabricPackage(),
            new SnackbarPackage(),
            new TwilioVoicePackage(),
            new SvgPackage(),
            new VectorIconsPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "worker/index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    Fabric.with(this,
            new Crashlytics.Builder()
                    .core(new CrashlyticsCore.Builder()
                            .disabled(mReactNativeHost.getUseDeveloperSupport())
                            .build())
                    .build());
  }
}
