package com.uep.moodleproject;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ApplicationShutdownHook
{
    @PreDestroy
    public void onShutdown()
    {
        DatabaseExporter.exportDatabase();
    }
}
