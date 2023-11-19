package com.guilherme.MusicApp.services;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ChatGpt {
    public static String infoArtista(String artista) {
        OpenAiService service = new OpenAiService(System.getenv("API_CHAT_GPT"));

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("me de informações sobre este artista: " + artista)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
