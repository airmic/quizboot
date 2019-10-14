package ru.otus.hw.quizboot.config;

import lombok.Data;
import org.springframework.context.MessageSource;

import java.util.Locale;

@Data
public class QuizSettings {

    private Locale locale;
    private String fileNameTemplate;
    private MessageSource messageSource;

    public QuizSettings(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    public String getResultFileName() {
        String languageDir = messageSource.getMessage(Consts.QUIZ_DIR, null, locale);
        return String.format(getFileNameTemplate(), languageDir);
    }
}
