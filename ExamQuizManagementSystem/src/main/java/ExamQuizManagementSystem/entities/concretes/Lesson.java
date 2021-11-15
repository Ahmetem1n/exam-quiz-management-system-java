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
@Table(name = "lessons")
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	public int lessonId;

	@Column(name = "teacher_id")
	public int teacherId;

	@Column(name = "department_id")
	public int departmentId;

	@Column(name = "lesson_name")
	public String lessonName;

	@Column(name = "lesson_teams_code")
	public String lessonTeamsCode;

	@Column(name = "lesson_material_link")
	public String lessonMaterialLink;
}
