package top.ourck.beans;
// Generated 2019-3-17 22:07:24 by Hibernate Tools 5.3.6.Final


/**
 * Property generated by hbm2java
 */
@SuppressWarnings("serial")
public class Property implements java.io.Serializable {

	private Integer id;
	private Category category;
	private String name;

	public Property() {
	}

	public Property(Category category, String name) {
		this.category = category;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
