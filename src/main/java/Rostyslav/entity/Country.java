package Rostyslav.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "country")
@Getter @Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = "cityes")
public class Country extends BaseClass {

	@Column(name = "name", length = 100, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "country")
	private List<City> cityes;
	
}
