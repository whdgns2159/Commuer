package common.controller;
//�߻� Ŭ����
//Action�������̽��� ��ӹ޾Ƽ� execute()�߻� �޼ҵ带 ����� ���´�.
abstract public class AbstractAction  implements Action{

	private String viewPage; //�������� ���� ���� ����
	private boolean isRedirect;
	//������ �̵� ����� redirect�� true, forward�� false���� ���� ����
	
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
