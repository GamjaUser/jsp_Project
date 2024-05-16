package DTO;

public class OrderDTO {
    private int orderId; // 주문번호
    private String id; //회원아이디
    private int price; //총결제금액
    private String card; //주문날짜
    private String name; //결제카드회사
    private int zipcode; //받는분성함
    private String addr; //우편번호
    private String addrDetail; //받는분주소
    private String tel; //상세주소
    private String req; //받는분 전화번호
    private int itemCNT; //배송요청사항
    private int productid; //주문상품개수


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public int getItemCNT() {
        return itemCNT;
    }

    public void setItemCNT(int itemCNT) {
        this.itemCNT = itemCNT;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
    
    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", card='" + card + '\'' +
                ", name='" + name + '\'' +
                ", zipcode=" + zipcode +
                ", addr='" + addr + '\'' +
                ", addrDetail='" + addrDetail + '\'' +
                ", tel='" + tel + '\'' +
                ", req='" + req + '\'' +
                ", itemCNT=" + itemCNT +
                ", productid=" + productid +
                '}';
    }
}