package org.zh.unit;

public class BaseBean {
	private Integer currentPage;//第几条开始
	private Integer lineSize;//每页显示几条

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getLineSize() {
		return lineSize;
	}

	public void setLineSize(Integer lineSize) {
		this.lineSize = lineSize;
	}

}
