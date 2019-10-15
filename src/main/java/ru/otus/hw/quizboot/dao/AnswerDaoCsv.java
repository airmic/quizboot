package ru.otus.hw.quizboot.dao;

import ru.otus.hw.quizboot.config.ConsoleContext;
import ru.otus.hw.quizboot.config.QuizSettings;
import ru.otus.hw.quizboot.domain.Answer;
import ru.otus.hw.quizboot.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AnswerDaoCsv implements AnswerDao {

    private List<Answer> answerList;
    private final ConsoleContext consoleContext;
    private final QuizSettings quizSettings;

    public AnswerDaoCsv(QuizSettings quizSettings, ConsoleContext consoleContext) {
        this.quizSettings = quizSettings;
        this.consoleContext = consoleContext;
        answerList = new ArrayList<>();

    }


    @Override
    public List<Answer> getAnswerList() {
        if( answerList.isEmpty() )
            reloadQuiz();
        return answerList;
    }


    public void reloadQuiz() {

        answerList.clear();

//        String locFilename = String.format(quizSettings.getFileNameTemplate(), quizSettings.getLocale().getLanguage());
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(quizSettings.getResultFileName())))) {

            String csvLine;
            String[] splitedCsvLine;
            while ((csvLine = br.readLine()) != null) {
                splitedCsvLine = csvLine.split(";");
                if (splitedCsvLine.length > 2) {
                    answerList.add(new Answer(new Question(splitedCsvLine[0], splitedCsvLine[1], Arrays.asList(Arrays.copyOfRange(splitedCsvLine, 2, splitedCsvLine.length)))));
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Quiz file read error");
        }
    }


}
