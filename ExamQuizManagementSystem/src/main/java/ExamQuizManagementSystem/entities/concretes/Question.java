package ExamQuizManagementSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	public int questionId;

	@Column(name = "exam_id")
	public int examId;

	@Column(name = "question_text")
	public String questionText;

	@Column(name = "question_options_text")
	public String questionOptionsText;

	@Column(name = "true_option")
	public char trueOption;

	@Column(name = "marked_option")
	public char markedOption;

}
