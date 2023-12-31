package com.gafarov.bastion.model.quiz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gafarov.bastion.entity.quiz.QuizType;
import com.gafarov.bastion.model.quiz.QuestionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Integer id;
    @JsonProperty("quiz_type")
    private QuizType quizType;
    @JsonProperty("questions")
    private List<QuestionDto> questionList;
}
