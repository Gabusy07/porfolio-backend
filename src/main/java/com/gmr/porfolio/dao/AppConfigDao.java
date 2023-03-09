package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.AppConfig;

public interface AppConfigDao {
    AppConfig addAppConfig();
    AppConfig getAppConfig();
    AppConfig changeConfig(AppConfig config);
}
