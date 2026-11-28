package com.startupmanager;
public class StartupApp {
    private String name;
    private String executablePath;
    private boolean enabled;

    public StartupApp(String name, String executablePath) {
        this.name =name;
        this.executablePath = executablePath;
        this.enabled = true;
    }
    public String getName() {
        return name;
    }
    public String getExecutablePath() {
        return executablePath;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setExecutablePath(String executablePath) {
        this.executablePath = executablePath;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}