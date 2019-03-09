package kr.or.connect.todo.dto;

public class TodoDto {
	private Long id;
	private String name;
	private String regdate;
	private Integer sequence;
	private String title;
	private String type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public TodoDto(Long id, String name, String regdate, Integer sequence, String title, String type) {
		super();
		this.id = id;
		this.name = name;
		this.regdate = regdate;
		this.sequence = sequence;
		this.title = title;
		this.type = type;
	}
	
	public TodoDto(String title, String name, Integer sequence) {
		super();
		this.title = title;
		this.name = name;
		this.sequence = sequence;
	}
	
	public TodoDto(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", name=" + name + ", regdate=" + regdate + ", sequence=" + sequence + ", title="
				+ title + ", type=" + type + "]";
	}
	
	
}
