package com.main.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

@RestController
public class TranslatorController {

	@GetMapping("/text")
	List<String> all() {
		List<String> response = new ArrayList<>();
		String fileName = "C:\\audio.raw"; // Specify audio file path
		Path path = Paths.get(fileName);
		System.out.print(path);
		try (SpeechClient speechClient = SpeechClient.create()) {
			byte[] data = Files.readAllBytes(path);
			// Voice recognition settings
			RecognitionConfig recConfig = RecognitionConfig.newBuilder()
					.setEncoding(RecognitionConfig.AudioEncoding.LINEAR16).setLanguageCode("en-US") // Specify input
																									// language
					.setSampleRateHertz(16000).build();
			RecognitionAudio recognitionAudio = RecognitionAudio.newBuilder()
					.setContent(com.google.protobuf.ByteString.copyFrom(data)).build();
			// Performing speech recognition
			RecognizeResponse recognizeResponse = speechClient.recognize(recConfig, recognitionAudio);
			String transcript = recognizeResponse.getResultsList().get(0).getAlternativesList().get(0).getTranscript();

			// Setting up and running translations
			Translate translate = TranslateOptions.getDefaultInstance().getService();
			Translation translation = translate.translate(transcript, Translate.TranslateOption.targetLanguage("ja")); // Specify
																														// target																											// language
			response.add("Original: %s" + transcript);
			response.add("Translated: %s" + translation.getTranslatedText());
		} catch (Exception e) {
			new Exception("Error server");
		}
		return response;
	}

	@PostMapping("/TextPost")
	String newEmployee(@RequestBody String newEmployee) {
		return new String();
	}
}
