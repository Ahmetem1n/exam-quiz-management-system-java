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
@Table(name = "users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public int userId;

	@Column(name = "user_firstname")
	public String userFirstName;

	@Column(name = "user_lastname")
	public String userLastName;

	@Column(name = "user_email")
	public String userEmail;

	@Column(name = "user_password")
	public String userPassword;

	@Column(name = "user_gender")
	public String userGender;

	@Column(name = "user_photo")
	public String userPhoto;

	@Column(name = "role_id")
	public int roleId;

}
