package Rostyslav.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "city")
@Getter @Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"country", "user"})
public class City extends BaseClass {

	@Column(name = "name", length = 100, unique = true)
	private String name;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;
	
	@OneToMany(mappedBy = "city")
	private List<User> user;
}
