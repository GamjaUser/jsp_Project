package DTO;

public class ProductDTO {
    private int prouctid; //��ǰ������ȣ
    private String name; //��ǰ�̸�
    private String img; //�̹��� URL
    private String comment; //��ǰ����
    private int price; //�ǸŰ�
    private int cnt; //���
    private String productKind; //��ǰ����

    public void setProuctid(int prouctid){this.prouctid = prouctid;}
    public void setName(String name){this.name = name;}
    public void setImg(String img){this.img = img;}
    public void setComment(String comment){this.comment = comment;}
    public void setPrice(int price){this.price = price;}
    private void setCnt(int cnt){this.cnt = cnt;}
    private void setProductKind(String productKind){this.productKind = productKind;}

    @Override
    public String toString() {
        return "ProductDTO{" +
                "prouctid=" + prouctid +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", comment='" + comment + '\'' +
                ", price=" + price +
                ", cnt=" + cnt +
                ", productKind='" + productKind + '\'' +
                '}';
    }
}

