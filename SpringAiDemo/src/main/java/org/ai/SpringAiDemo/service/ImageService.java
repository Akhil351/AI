package org.ai.SpringAiDemo.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final OpenAiImageModel openAiImageModel;
    public ImageService(OpenAiImageModel openAiImageModel){
        this.openAiImageModel=openAiImageModel;
    }
    public ImageResponse generateImage(String prompt,String quality,int height,int width){
        return openAiImageModel.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder().withModel("dall-e-3").
                                withQuality(quality).withN(1).withHeight(height).withWidth(width).build()));
    }

}
