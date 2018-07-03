package ru.yandex.yamblz.developer_settings;

import android.app.Application;
import android.support.annotation.NonNull;

public class DevMetricsProxyImpl implements DevMetricsProxy {

  @NonNull
  private final Application application;

  public DevMetricsProxyImpl(@NonNull final Application application) {
    this.application = application;
  }

  @Override
  public void apply() {
  }
}
