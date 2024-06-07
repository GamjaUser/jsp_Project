package DAO;

import DTO.OrderDTO;
import common.DBConnPool;

public class OrderDAO extends DBConnPool{
	public OrderDAO() {
		super();
	}
	
	public void insertOderData(OrderDTO dto) {
		
		String sql = "INSERT INTO \"order\"(ORDERID, ID, PRICE, RDATE, CARD, NAME, ZIPCODE, ADDR, ADDRDETAIL, TEL, REQ, ITEMCNT, PRODUCTID)"
				+ " VALUES (1, 'user001', 50000, TO_DATE('2024-05-31', 'YYYY-MM-DD'), '1234-5678-9012-3456', '홍길동', 12345, '서울특별시 강남구 테헤란로 123', '101호', '010-1234-5678', '빠른 배송 부탁드립니다', 3, 1001)";
	}
}
