package com.startupmanager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LaunchApp {
    public void launch(StartupApp app) throws IOException {
        //if the app isn't enabled, it doesn't launch
        if (!app.isEnabled()) {
            return;
        }
        //gets the executable path from the application
        Path executable = Path.of(app.getExecutablePath());

        //checks if it can even execute
        if (!Files.isRegularFile(executable)) {
            throw new IOException(
                    "Application not found: " + executable
            );
        }
        //start the application
        ProcessBuilder process = new ProcessBuilder(executable.toString());
        process.start();
    }
}
