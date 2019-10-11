package ru.otus.hw.quizboot.config;

import lombok.Data;

import java.util.Locale;

@Data
public class QuizSettings {

    private Locale locale;
    private String fileNameTemplate;
}
