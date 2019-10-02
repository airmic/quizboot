package ru.otus.hw.quizboot.service;


public interface CommunicateService {
    void putI10nCode(String str);
    void putI10nCode(String str, Object[] objs);
    void putString(String str);
    void putEmptyLines(int num);

    String getObject();

    void inputLocale();
}
