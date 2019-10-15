package ru.otus.hw.quizboot.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw.quizboot.service.QuestionService;

@ShellComponent
public class QuizShell {

    @Autowired
    QuestionService questionService;

    String login;

    @ShellMethod(value="Login", key = {"l", "login"})
    public String loginCmd(@ShellOption(defaultValue="mike") String login) {
        this.login = login;
        System.out.println(login);
        return "";
    }

    @ShellMethod(value="run", key = {"r", "run"})
    @ShellMethodAvailability("isLogin")
    public void runQuiz() {
        questionService.executeQuiz();
    }

    private Availability isLogin() {
        return ((login == null) || login.isEmpty()) ? Availability.unavailable("Необходимо залогиниться") : Availability.available();
    }
}
