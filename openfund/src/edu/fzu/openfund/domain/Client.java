package edu.fzu.openfund.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="client")
public class Client {
	@Id
	@GenericGenerator(name="assigned",strategy="assigned")
	@GeneratedValue(generator="assigned")
	@Column(name="IDCARD_NO")
	private String IDCardNO; // 客户身份证号
	
	@Column(name="CLIENT_NAME")
	private String clientName; // 客户姓名
	
	@Column(name="CLIENT_SEX")
	private String clientSex; // 客户性别
	
	@Column(name="CLIENT_PHONE")
	private String clientPhone; // 客户联系电话
	
	@Column(name="CLIENT_ADDRESS")
	private String clientAddress; // 客户地址
	
	@Column(name="CLIENT_EMAIL")
	private String clientEmail; // 客户电邮
	
	@Column(name="CLIENT_HOBBY")
	private String clientHobby; // 客户爱好
	
	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date clientCreateDate; // 客户创建时间
	
	@OneToOne(targetEntity=FinAcc.class,mappedBy="client")
	private FinAcc finAcc;
	public String getIDCardNO() {
		return IDCardNO;
	}

	public void setIDCardNO(String iDCardNO) {
		IDCardNO = iDCardNO;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSex() {
		return clientSex;
	}

	public void setClientSex(String clientSex) {
		this.clientSex = clientSex;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientHobby() {
		return clientHobby;
	}

	public void setClientHobby(String clientHobby) {
		this.clientHobby = clientHobby;
	}

	public Date getClientCreateDate() {
		return clientCreateDate;
	}

	public void setClientCreateDate(Date clientCreateDate) {
		this.clientCreateDate = clientCreateDate;
	}

	public FinAcc getFinAcc() {
		return finAcc;
	}

	public void setFinAcc(FinAcc finAcc) {
		this.finAcc = finAcc;
	}
}
