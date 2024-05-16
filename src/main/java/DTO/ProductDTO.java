package DTO;

public class ProductDTO {
    private int prouctid; //상품고유번호
    private String name; //상품이름
    private String img; //이미지 URL
    private String comment; //상품설명
    private int price; //판매가
    private int cnt; //재고
    private String productKind; //상품종류

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

