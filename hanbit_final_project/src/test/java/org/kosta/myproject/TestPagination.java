package org.kosta.myproject;

public class TestPagination {
	public static void main(String[] args) {
		PaginationDemo p = new PaginationDemo(47, 10);
		System.out.println("//////// 총게시물31개,현재페이지4 //////////");
		// 현페이지의 시작 row number 를 조회 46
		System.out.println("getStartRowNumber:" + p.getStartRowNumber());
		// 현페이지의 마지막 row number 를 조회 47
		System.out.println("getEndRowNumber:" + p.getEndRowNumber());
		// 전체 페이지 수 : 10
		System.out.println("getTotalPage:" + p.getTotalPage());
		// 전체 페이지 그룹 수 : 3
		System.out.println("getTotalPageGroup:" + p.getTotalPageGroup());
		// 게시물수 47 -> 총페이지수 10 -> 총페이지그룹->3
		// 현재 페이지 그룹 : 3
		System.out.println("getNowPageGroup:" + p.getNowPageGroup());
		// 페이지 그룹의 시작 페이지 : 9
		System.out.println("getStartPageOfPageGroup:" + p.getStartPageOfPageGroup());
		// 페이지 그룹의 마지막 페이지 : 10

		System.out.println("getEndPageOfPageGroup:" + p.getEndPageOfPageGroup());
		// 이전 페이지 그룹이 있는 지 : true
		System.out.println("isPreviousPageGroup:" + p.isPreviousPageGroup());
		// 다음 페이지 그룹이 있는 지 : false
		System.out.println("isNextPageGroup:" + p.isNextPageGroup());

		System.out.println("//////// 총게시물31개,현재페이지4 //////////");
		p = new PaginationDemo(31, 4);// 게시물수 31 현재 페이지 4
		// 현페이지의 시작 row number 를 조회 16
		System.out.println("getStartRowNumber:" + p.getStartRowNumber());
		// 현페이지의 마지막 row number 를 조회 20
		System.out.println("getEndRowNumber:" + p.getEndRowNumber());
		// 총 페이지수 7
		System.out.println("getTotalPage:" + p.getTotalPage());
		// 총 페이지 그룹수 2
		System.out.println("getTotalPageGroup:" + p.getTotalPageGroup());
		// 현재 페이지 그룹 : 1
		System.out.println("getNowPageGroup:" + p.getNowPageGroup());
		// 페이지 그룹의 시작 페이지 : 1
		System.out.println("getStartPageOfPageGroup:" + p.getStartPageOfPageGroup());
		// 페이지 그룹의 마지막 페이지 : 4
		System.out.println("getEndPageOfPageGroup:" + p.getEndPageOfPageGroup());
		// 이전 페이지 그룹이 있는 지 : false
		System.out.println("isPreviousPageGroup:" + p.isPreviousPageGroup());
		// 다음 페이지 그룹이 있는 지 : true
		System.out.println("isNextPageGroup:" + p.isNextPageGroup());
	}
}
