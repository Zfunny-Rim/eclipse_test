package board.model;

import org.hibernate.validator.constraints.NotBlank;

public class BoardBean {
	private int num;
	@NotBlank(message="필수 입력사항입니다.")
	private String writer;
	@NotBlank(message="필수 입력사항입니다.")
	private String email;
	@NotBlank(message="필수 입력사항입니다.")
	private String subject;
	@NotBlank(message="필수 입력사항입니다.")
	private String passwd;
	@NotBlank(message="필수 입력사항입니다.")
	private String content;
	private String regdate;
	private int readcount;
	private int ref;
	private int restep;
	private int relevel;
	private String ip;
	
	public BoardBean() {
		super();
	}
	public BoardBean(int num, String writer, String email, String subject, String passwd, String regdate, int readcount,
			int ref, int restep, int relevel, String content, String ip) {
		super();
		this.num = num;
		this.writer = writer;
		this.email = email;
		this.subject = subject;
		this.passwd = passwd;
		this.regdate = regdate;
		this.readcount = readcount;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
		this.content = content;
		this.ip = ip;
	}
	
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
