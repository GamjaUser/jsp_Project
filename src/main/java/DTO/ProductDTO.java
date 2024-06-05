package DTO;

import oracle.sql.DATE;

public class ProductDTO {
    private int productId; //��ǰ������ȣ
    private String name; //��ǰ�̸�
    private String img; //�̹��� URL
    private String comment; //��ǰ����
    private int price; //�ǸŰ�
    private String productKind; //��ǰ����


    public void setProdcutId(int productId){this.productId = productId;}
    public void setName(String name){this.name = name;}
    public void setImg(String img){this.img = img;}
    public void setComment(String comment){this.comment = comment;}
    public void setPrice(int price){this.price = price;}
    public void setProductKind(String productKind){this.productKind = productKind;}

    public int getProductId() {
    	return productId;
    }

    
    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getComment() {
        return comment;
    }

    public int getPrice() {
        return price;
    }


    public String getProductKind() {
        return productKind;
    }
    
    @Override
    public String toString() {
        return "ProductDTO{" +
                "prouctid=" + productId +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", comment='" + comment + '\'' +
                ", price=" + price +
                ", productKind='" + productKind + '\'' +
                '}';
    }
}

