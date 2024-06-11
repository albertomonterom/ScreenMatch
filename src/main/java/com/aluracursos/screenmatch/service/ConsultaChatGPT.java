package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    private static final String CHATGPTAPI = System.getenv("CHAT_GPT_API");
    public static String obtenerTraduccion(String texto){
        OpenAiService service = new OpenAiService(CHATGPTAPI);
        CompletionRequest requisicion = CompletionRequest.builder()
                .prompt("Traduce a español el siguiente texto: " + texto)
                .model("gpt-3.5-turbo-instruct")
                .maxTokens(1000)
                .temperature(0.7)
                .build();
        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}
