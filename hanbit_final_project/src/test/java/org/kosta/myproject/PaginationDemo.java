package org.kosta.myproject;

public class PaginationDemo {
	private int nowPage = 1; // 현재 페이지
	private int postCountPerPage = 10; // 페이지당 게시물수
	private int pageCountPerPageGroup = 5; // 페이지 그룹당 페이지수
	private int totalPostCount; // 총게시물수 ( 데이터베이스에 저장되어 있는)

	public PaginationDemo(int totalPostCount) {
		this.totalPostCount = totalPostCount;
	}

	public PaginationDemo(int totalPostCount, int nowPage) {
		this.totalPostCount = totalPostCount;
		this.nowPage = nowPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public int getStartRowNumber() {
		return (this.nowPage - 1) * this.postCountPerPage + 1;
	}

	public int getEndRowNumber() {
		int endRowNumber = getStartRowNumber() + this.postCountPerPage - 1;
		if (endRowNumber > this.totalPostCount) {
			endRowNumber = this.totalPostCount;
		}
		return endRowNumber;
	}

	public int getTotalPage() {
		int totalPage = 0;
		if (totalPostCount % postCountPerPage == 0) {
			totalPage = totalPostCount / postCountPerPage;
		} else if (totalPostCount % postCountPerPage > 0) {
			totalPage = totalPostCount / postCountPerPage + 1;
		}
		return totalPage;
	}

	public int getTotalPageGroup() {
		int totalPageGroup = 0;
		if (getTotalPage() % this.pageCountPerPageGroup == 0) {
			totalPageGroup = this.getTotalPage() / pageCountPerPageGroup;
		} else if (getTotalPage() % pageCountPerPageGroup != 0) {
			totalPageGroup = getTotalPage() / pageCountPerPageGroup + 1;
		}
		return totalPageGroup;
	}

	public int getNowPageGroup() {
		int nowPageGroup = 0;
		if (nowPage % pageCountPerPageGroup == 0) {
			nowPageGroup = nowPage / pageCountPerPageGroup;
		} else if (nowPage % pageCountPerPageGroup > 0) {
			nowPageGroup = nowPage / pageCountPerPageGroup + 1;
		}
		return nowPageGroup;
	}

	public int getStartPageOfPageGroup() {
		return (getNowPageGroup() - 1) * pageCountPerPageGroup + 1;
	}

	public int getEndPageOfPageGroup() {
		int endPage = 0;
		if (getNowPageGroup() * pageCountPerPageGroup > getTotalPage()) {
			endPage = getTotalPage();
		} else {
			endPage = getNowPageGroup() * pageCountPerPageGroup;
		}
		return endPage;
	}

	public boolean isPreviousPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() > 1) {
			flag = true;
		}
		return flag;
	}

	public boolean isNextPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() < this.getTotalPageGroup()) {
			flag = true;
		}
		return flag;
	}
}
