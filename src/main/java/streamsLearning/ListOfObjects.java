package streamsLearning;

public class ListOfObjects {
	String name;
	int id;

	public ListOfObjects(int id, String name) {
		this.id = id;
        this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
