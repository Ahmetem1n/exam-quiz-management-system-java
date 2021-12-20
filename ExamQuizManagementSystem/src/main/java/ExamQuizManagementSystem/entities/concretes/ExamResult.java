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
@Table(name = "exam_result")
public class ExamResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "result_id")
	private int resultId;

	@Column(name = "result")
	private int result;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
}
