package com.solvd.savich.gui;

public enum Resource {
    TESTDATA("src/main/java/resources/testdata.properties"),
    CONFIG("src/main/java/resources/config.properties");

    private String configPath;
    Resource(String configPath){
        this.configPath = configPath;
    }
    public String getConfigPath(){return configPath;}
}
