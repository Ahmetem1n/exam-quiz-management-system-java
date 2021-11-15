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
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	public int studentId;

	@Column(name = "user_id")
	public int userId;

	@Column(name = "student_number")
	public String studentNumber;

	@Column(name = "student_nationality_id")
	public String studentNationalityId;

	@Column(name = "student_grade")
	public int studentGrade;
}
