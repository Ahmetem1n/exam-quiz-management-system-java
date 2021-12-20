package ExamQuizManagementSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int questionId;

	@Column(name = "question_text")
	private String questionText;

	@Column(name = "option_a")
	private String OptionA;

	@Column(name = "option_b")
	private String OptionB;

	@Column(name = "option_c")
	private String OptionC;

	@Column(name = "option_d")
	private String OptionD;

	@Column(name = "option_e")
	private String OptionE;

	@Column(name = "true_option")
	private String trueOption;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;

}
