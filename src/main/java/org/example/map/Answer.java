package org.example.map;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @Column(name = "id")
    private int answerId;
    private String answer;

    // this won't create another column in answer table, as this would be taken care by question table/class
    @OneToOne(mappedBy = "questionAnswer")
    private Question q;

    public Answer() {
    }

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQ() {
        return q;
    }

    public void setQ(Question q) {
        this.q = q;
    }
}
