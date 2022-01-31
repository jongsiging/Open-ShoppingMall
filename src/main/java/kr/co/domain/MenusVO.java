package kr.co.domain;

import java.io.Serializable;

public class MenusVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int menu_no;
	private String menu_name;
	private String menu_href;
	
	public MenusVO() {
		// TODO Auto-generated constructor stub
	}

	public MenusVO(int menu_no, String menu_name, String menu_href) {
		super();
		this.menu_no = menu_no;
		this.menu_name = menu_name;
		this.menu_href = menu_href;
	}

	public int getMenu_no() {
		return menu_no;
	}

	public void setMenu_no(int menu_no) {
		this.menu_no = menu_no;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_href() {
		return menu_href;
	}

	public void setMenu_href(String menu_href) {
		this.menu_href = menu_href;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "{'menu_no':" + menu_no + ", 'menu_name':'" + menu_name + "', 'menu_href':'" + menu_href + "'}";
	}
	
}
