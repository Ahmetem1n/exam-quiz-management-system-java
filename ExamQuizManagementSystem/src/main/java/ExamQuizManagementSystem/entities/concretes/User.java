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
@Table(name = "users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_firstname")
	private String userFirstname;

	@Column(name = "user_lastname")
	private String userLastname;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_nationality_id")
	private String nationalityId;

	@Column(name = "user_gender")
	private String userGender;

	@Column(name = "user_photo")
	private String userPhoto;

	@Column(name = "user_password")
	private String userPassword;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private UserRole userRole;

}
