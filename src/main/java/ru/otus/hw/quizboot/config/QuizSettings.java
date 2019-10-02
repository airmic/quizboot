package ru.otus.hw.quizboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.Locale;

@Data
public class QuizSettings {

    @Value("${default.language}")
    private Locale locale;
    @Value("${question.resource}")
    private String fileNameTemplate;
}
