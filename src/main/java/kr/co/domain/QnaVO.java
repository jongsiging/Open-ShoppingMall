package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class QnaVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int qna_no;
	private int board_no;
	private String member_id;
	private String qna_title;
	private String qna_content;
	private String qna_regdate;
	private String qna_updatedate;
	private String qna_answer;
	private int item_no;
	private String item_name;
	private String file_name;

	public QnaVO() {
	}

	public QnaVO(int qna_no, int board_no, String member_id, String qna_title, String qna_content, String qna_regdate,
			String qna_updatedate, String qna_answer, int item_no, String item_name, String file_name) {
		super();
		this.qna_no = qna_no;
		this.board_no = board_no;
		this.member_id = member_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_regdate = qna_regdate;
		this.qna_updatedate = qna_updatedate;
		this.qna_answer = qna_answer;
		this.item_no = item_no;
		this.item_name = item_name;
		this.file_name = file_name;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public String getQna_regdate() {
		return qna_regdate;
	}

	public void setQna_regdate(String qna_regdate) {
		this.qna_regdate = qna_regdate;
	}

	public String getQna_updatedate() {
		return qna_updatedate;
	}

	public void setQna_updatedate(String qna_updatedate) {
		this.qna_updatedate = qna_updatedate;
	}

	public String getQna_answer() {
		return qna_answer;
	}

	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QnaVO other = (QnaVO) obj;
		return board_no == other.board_no && Objects.equals(member_id, other.member_id) && qna_no == other.qna_no;
	}

	@Override
	public String toString() {
		return "{'qna_no':" + qna_no + ", 'board_no':" + board_no + ", 'member_id':'" + member_id + "', 'qna_title':'"
				+ qna_title + "', 'qna_content':'" + qna_content + "', 'qna_regdate':'" + qna_regdate + "', 'qna_updatedate':'"
				+ qna_updatedate + "', 'qna_answer':'" + qna_answer + "', 'item_no':" + item_no + ", 'item_name':'" + item_name
				+ "', 'file_name':'" + file_name + "'}";
	}



}
