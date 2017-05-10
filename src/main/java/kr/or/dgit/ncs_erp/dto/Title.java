package kr.or.dgit.ncs_erp.dto;

public class Title {
	private String no;
	private String title;

	public Title(String no) {
		this.no = no;
	}

	public Title(String no, String title) {
		this.no = no;
		this.title = title;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("%s", title);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Title te = (Title) obj;
		if (no == te.no && title.equals(te.title)) {
			return true;
		} else {
			return false;
		}
	}

	public Object[] toArray() {
		return new Object[] { no, title };
	}
}
