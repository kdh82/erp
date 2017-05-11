package kr.or.dgit.ncs_erp.dto;

public class Title {
	private int tCode;
	private String tName;
	
	public Title() {}
	
	public Title(int tCode, String tName) {
		this.tCode = tCode;
		this.tName = tName;
	}

	public int gettCode() {
		return tCode;
	}

	public void settCode(int tCode) {
		this.tCode = tCode;
	}

	public String getTitle() {
		return tName;
	}

	public void setTitle(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() {
		return String.format("%s, %s]", tCode, tName);
	}
	public Object toArray(){
		return new Object[] {tCode, tName};	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (tCode != other.tCode)
			return false;
		return true;
	}
	
	
	
}
