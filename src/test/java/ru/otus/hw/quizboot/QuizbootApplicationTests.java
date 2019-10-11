package ru.otus.hw.quizboot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.hw.quizboot.config.ServiceConfigs;
import ru.otus.hw.quizboot.dao.AnswerDao;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@EnableConfigurationProperties
@ContextConfiguration(classes = ServiceConfigs.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class QuizbootApplicationTests {

    @Autowired
    AnswerDao answerDao;

    @DisplayName("Тест на наличие DAO")
    @Test
    public void testContextLoads() {
        assertNotNull(answerDao, () -> "Dao not loaded");
    }

    @DisplayName("Тест на загрузку DAO")
    @Test
    public void ContextLoads() {
        assertEquals(answerDao.getAnswerList().size(),5,() -> "Error questions count");
    }


}
