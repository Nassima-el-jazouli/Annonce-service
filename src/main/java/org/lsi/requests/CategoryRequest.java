package org.lsi.requests;

public class CategoryRequest {
	private String name;

	public CategoryRequest(String name) {
		super();
		this.name = name;
	}

	public CategoryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CategoryRequest [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
