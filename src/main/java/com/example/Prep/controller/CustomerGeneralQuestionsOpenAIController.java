package com.example.Prep.controller;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptions;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prep.dto.request.ai.ChatGenRequest;
import com.example.Prep.dto.request.ai.ImageGenRequest;

@RestController
public class CustomerGeneralQuestionsOpenAIController {

	private final ImageModel imageModel;
	private final ChatModel chatModel;

	public CustomerGeneralQuestionsOpenAIController(ImageModel imageModel, ChatModel chatModel) {
		this.imageModel = imageModel;
		this.chatModel = chatModel;
	}

	@GetMapping(path = "/customer/questions/image/openai")
	public String generateImageUsingOpenAI(@RequestBody ImageGenRequest imageGenRequest) {

		ImageOptions imageOptions = ImageOptionsBuilder.builder().withHeight(1024).withWidth(1024).withModel("dall-e-3").build();

		ImagePrompt imagePrompt = new ImagePrompt(imageGenRequest.prompt(), imageOptions);
		System.out.println("ImageModel - STARTED!!! - " + imageGenRequest.prompt());
		ImageResponse response = imageModel.call(imagePrompt);
		System.out.println("ImageModel - DONE!!! " + response);

		return "redirect:" + response.getResult().getOutput().getUrl();
	}

	@GetMapping(path = "/customer/questions/chatbot/openai")
	public String generateAnswerUsingOpenAI(@RequestBody ChatGenRequest chatGenRequest) {

		System.out.println("ChatModel - STARTED!!! - " + chatGenRequest.prompt());
		System.out.println(chatModel.getDefaultOptions());
		String response = chatModel.call(chatGenRequest.prompt());
		System.out.println("ChatModel - DONE!!! " + response);

		return response;
	}

}
