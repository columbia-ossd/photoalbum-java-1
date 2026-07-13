public class Photo {
	
	private String name;
	private String desc;
	
	public Photo(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getFilename() { return name; }
	public String getDescription() { return desc; }

  public void setDescription(String desc) {
    this.desc = desc;
  }
	
	
	public String toString() {
		return desc + " (" + name + ") ";
	}
	
}
