package ru.otus.hw.quizboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.otus.hw.quizboot.service.QuestionService;
import ru.otus.hw.quizboot.service.QuestionServiceImp;

import java.util.Locale;

@SpringBootApplication
public class QuizbootApplication implements CommandLineRunner {

    @Autowired
    QuestionService questionService;

    public static void main(String[] args) {
//        Locale.setDefault(Locale.forLanguageTag("ru-RU"));
        SpringApplication.run(QuizbootApplication.class, args);
    }


    @Override
    public void run(String... args)  {
//        questionService.executeQuiz();
    }
}
