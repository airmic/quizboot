package ru.otus.hw.quizboot.dao;

import ru.otus.hw.quizboot.domain.Answer;

import java.util.List;

public interface AnswerDao {
    List<Answer> getAnswerList();
}
