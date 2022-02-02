package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class SellerVO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String seller_id;
	private String seller_pw;
	private String seller_name;
	private String seller_email;
	private String seller_phone;
	
	
	public SellerVO() {
		// TODO Auto-generated constructor stub
	}

	public SellerVO(String seller_id, String seller_pw, String seller_name, String seller_email, String seller_phone) {
		super();
		this.seller_id = seller_id;
		this.seller_pw = seller_pw;
		this.seller_name = seller_name;
		this.seller_email = seller_email;
		this.seller_phone = seller_phone;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getSeller_pw() {
		return seller_pw;
	}

	public void setSeller_pw(String seller_pw) {
		this.seller_pw = seller_pw;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getSeller_phone() {
		return seller_phone;
	}

	public void setSeller_phone(String seller_phone) {
		this.seller_phone = seller_phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seller_id, seller_pw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellerVO other = (SellerVO) obj;
		return Objects.equals(seller_id, other.seller_id) && Objects.equals(seller_pw, other.seller_pw);
	}

	@Override
	public String toString() {
		return "SellerVO [seller_id=" + seller_id + ", seller_pw=" + seller_pw + ", seller_name=" + seller_name
				+ ", seller_email=" + seller_email + ", seller_phone=" + seller_phone + "]";
	}


}
