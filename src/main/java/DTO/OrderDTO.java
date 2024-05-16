package DTO;

public class OrderDTO {
    private int orderId; // �ֹ���ȣ
    private String id; //ȸ�����̵�
    private int price; //�Ѱ����ݾ�
    private String card; //�ֹ���¥
    private String name; //����ī��ȸ��
    private int zipcode; //�޴ºм���
    private String addr; //�����ȣ
    private String addrDetail; //�޴º��ּ�
    private String tel; //���ּ�
    private String req; //�޴º� ��ȭ��ȣ
    private int itemCNT; //��ۿ�û����
    private int productid; //�ֹ���ǰ����


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