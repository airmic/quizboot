package ru.otus.hw.quizboot.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.hw.quizboot.config.ServiceConfigs;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableConfigurationProperties
@ContextConfiguration(classes = ServiceConfigs.class,
        initializers = ConfigFileApplicationContextInitializer.class)
class AnswerDaoCsvTest {

    @Autowired
    AnswerDao answerDao;

    @DisplayName("Тест на наличие DAO")
    @Test
    public void testDaoLoads() {
        assertNotNull(answerDao, () -> "Dao not loaded");
    }

    @DisplayName("Тест на загрузку DAO")
    @Test
    void getAnswerList() {
        assertEquals(answerDao.getAnswerList().size(),5,() -> "Error questions count");
    }
}