package ru.otus.hw.quizboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.hw.quizboot.dao.AnswerDao;
import ru.otus.hw.quizboot.dao.AnswerDaoCsv;
import ru.otus.hw.quizboot.service.CommunicateService;
import ru.otus.hw.quizboot.service.CommunicateServiceImp;

@Configuration
@PropertySource("application.yml")
public class ServiceConfigs {
    @Bean
    @Autowired
    public CommunicateService communicateService(MessageSource messageSource, ConsoleContext consoleContext, QuizSettings quizSettings) {
        return new CommunicateServiceImp(messageSource, consoleContext, quizSettings);
    }

    @Bean
    @Autowired
    public AnswerDao answerDao(QuizSettings quizSettings, ConsoleContext consoleContext) {
        return new AnswerDaoCsv(quizSettings, consoleContext);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setBasename("/i18n/quiestion_service");
        return bundleMessageSource;
    }

    @Bean
    public ConsoleContext consoleContext() {
        return new ConsoleContext(System.in, System.out);
    }

    @Bean
    @ConfigurationProperties(prefix = "quiz")
    public QuizSettings quizSettings() {
        return new QuizSettings();
    }
}
