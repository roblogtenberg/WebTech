package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
public class User {

	private String surname;
	private String prefix;
	private String lastname;
	private String nickname;
	private String password;
	private ArrayList<Rating> ratings;
	private String token;

	public User() {

	}

	public User(String surname, String lastname, String nickname, String password) {
		this.surname = surname;
		this.lastname = lastname;
		this.nickname = nickname;
		this.password = password;
		this.ratings = new ArrayList<Rating>();
	}

	public User(String surname, String prefix, String lastname, String nickname, String password) {
		this.surname = surname;
		this.prefix = prefix;
		this.lastname = lastname;
		this.nickname = nickname;
		this.password = password;
		this.ratings = new ArrayList<Rating>();
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

	@XmlTransient
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void addRating(Rating rating) {
		ratings.add(rating);
	}

	@XmlTransient
	@JsonIgnore
	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	@XmlTransient
	@JsonIgnore
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean changeRating(String imdbId, int rating) {
		for (int i = 0; i < ratings.size(); i++) {
			if (ratings.get(i).getMovie().getIMBDCode().equals(imdbId)) {
				ratings.set(i, new Rating(rating, ratings.get(i).getMovie()));
				return true;
			}
		}
		return false;
	}
	
	public boolean removeRating(String imdbId) {
		for (int i = 0; i < ratings.size(); i++) {
			if (ratings.get(i).getMovie().getIMBDCode().equals(imdbId)) {
				ratings.remove(i);
				return true;
			}
		}
		return false;
	}
}
