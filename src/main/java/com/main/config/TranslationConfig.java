package com.main.config;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TranslationConfig {

    @Bean
    public Translate translateService() {
        // Set the path to your JSON key file
        String keyPath = "/path/to/your/credentials.json";

        // Initialize the Translate service
		Translate translate = TranslateOptions.newBuilder().setApiKey(keyPath).build().getService();
		return translate;
    }
}
