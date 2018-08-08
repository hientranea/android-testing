package com.example.android.testing.notes;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class MyApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Fabric.with(this, new Crashlytics());
    logUser();
  }

  private void logUser() {
    // TODO: Use the current user's information
    // You can call any combination of these three methods
    Crashlytics.setUserIdentifier("12345");
    Crashlytics.setUserEmail("user@fabric.io");
    Crashlytics.setUserName("Test User");
  }

}
