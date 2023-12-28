 package dao;

public class BoardItem {
    private int num;
    private String name;
    private String title;
    private String regDate;
    private int readCount;
    private String file1;
    // 다른 필드들도 필요에 따라 추가할 수 있습니다
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	@Override
	public String toString() {
		return "BoardItem [num=" + num + ", name=" + name + ", title=" + title + ", regDate=" + regDate + ", readCount="
				+ readCount + ", file1=" + file1 + "]";
	}

   
}