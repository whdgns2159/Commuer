package common.controller;
//추상 클래스
//Action인터페이스를 상속받아서 execute()추상 메소드를 멤버로 갖는다.
abstract public class AbstractAction  implements Action{

	private String viewPage; //뷰페이지 값을 가질 예정
	private boolean isRedirect;
	//페이지 이동 방식이 redirect면 true, forward는 false값을 가질 예정
	
	//setter, getter
	
	public String getViewPage() {
		return viewPage;
	}
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	

}
