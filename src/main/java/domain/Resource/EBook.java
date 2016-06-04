package domain.Resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

enum EBookType{


}

/*
* 电子书
*
* */
@Entity
@Table(name="EBook")
public class EBook extends ResourceBase {

	@Column(name="typeOfEBookType")
	private String typeOfEBookType;

	public String getTypeOfEBookType() {
		return typeOfEBookType;
	}
	public void setTypeOfEBookType(String typeOfEBookType) {
		this.typeOfEBookType = typeOfEBookType;
	}

}
