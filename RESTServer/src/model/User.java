package model;

public class User {

	private String surname;
	private String prefix;
	private String lastname;
	private String nickname;

	public User(String surname, String prefix, String lastname, String nickname) {
		this.surname = surname;
		this.prefix = prefix;
		this.lastname = lastname;
		this.nickname = nickname;
	}

	public String getSurname() {
		return surname;
	}

	public String getLastname() {
		if (prefix == null) {
			return lastname;
		} else {
			return lastname + ", " + prefix;
		}
	}

	public String getNickname() {
		return nickname;
	}

	public String getName() {
		if (prefix == null) {
			return surname + " " + lastname;
		}
		return surname + " " + prefix + " " + lastname;
	}
}
