package DTO;

public class CartDTO {
    private int productid; // ��ǰ������ȣ
    private String id; // ȸ�����̵�
    private int cnt; // ����

    public void setId(String id) {this.id = id;}
    public void setProductId(int productid){ this.productid = productid; }
    public void setCnt(int cnt) {this.cnt = cnt; }
    
    public String getId(){return id; }
    public int getProductId(){ return productid; }
    public int getCnt(){return cnt; }
    
    @Override
    public String toString() {
        return "CartDTO{" +
                "productid=" + productid +
                ", id='" + id + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}
