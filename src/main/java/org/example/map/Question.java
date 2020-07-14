package org.example.map;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @Column(name = "id")
    private int questionId;
    private String question;
    @OneToOne
    @JoinColumn(name = "ans_id")
    private Answer questionAnswer;

    public Question() {
    }

    public Question(int questionId, String question, Answer questionAnswer) {
        this.questionId = questionId;
        this.question = question;
        this.questionAnswer = questionAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(Answer questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
