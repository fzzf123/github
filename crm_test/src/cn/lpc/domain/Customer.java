package cn.lpc.domain;

public class Customer {
	private Integer cid;
	private String custName;
	private String custType;
	private String custPhone;
	private String custAddress;
	private User custLinkUser = new User();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public User getCustLinkUser() {
		return custLinkUser;
	}
	public void setCustLinkUser(User custLinkUser) {
		this.custLinkUser = custLinkUser;
	}
}
