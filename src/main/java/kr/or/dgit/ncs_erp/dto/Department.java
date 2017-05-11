package kr.or.dgit.ncs_erp.dto;

public class Department {
	private int dCode;
	private String dName;
	private int floor;

	public Department() {
	}

	public Department(int dCode, String dName, int floor) {
		this.dCode = dCode;
		this.dName = dName;
		this.floor = floor;
	}

	public int getdCode() {
		return dCode;
	}

	public void setdCode(int dCode) {
		this.dCode = dCode;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s", dCode, dName, floor);
	}

	public Object[] toArray() {
		return new Object[] { dCode, dName, floor };
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dCode;
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
		Department other = (Department) obj;
		if (dCode != other.dCode)
			return false;
		return true;
	}

}
