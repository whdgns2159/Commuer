package user.model;

public class UserBookmarkVO {

	private String id;
	private String tn;
	
	public UserBookmarkVO(String id, String tn) {
		super();
		this.id = id;
		this.tn = tn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	public UserBookmarkVO() {
		
	}

}
