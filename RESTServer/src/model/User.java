package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

	@XmlAttribute
	public String getSurname() {
		return surname;
	}

	@XmlAttribute
	public String getLastname() {
		if (prefix == null) {
			return lastname;
		} else {
			return lastname + ", " + prefix;
		}
	}

	@XmlAttribute
	public String getNickname() {
		return nickname;
	}

	@XmlAttribute
	public String getName() {
		if (prefix == null) {
			return surname + " " + lastname;
		}
		return surname + " " + prefix + " " + lastname;
	}
}
