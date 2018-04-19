package com.fatcatmuscat.VMessenger;


import android.content.res.AssetManager;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Before
    public void baseSetup() throws IOException {
        properties = new Properties();
        AssetManager testAssetManager = InstrumentationRegistry.getContext().getAssets();
        AssetManager.AssetInputStream assetStream =
                (AssetManager.AssetInputStream) testAssetManager.open("user.properties");
        properties.load(assetStream);

    }


}
