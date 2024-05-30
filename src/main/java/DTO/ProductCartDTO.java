package DTO;

public class ProductCartDTO {
	
	private int productId; //��ǰ�ڵ�
	private String name; //��ǰ �̸�
	private String img; //��ǰ �̹���
	private String comment; // ��ǰ ����
	private int price; //��ǰ ����
	
	private String id; //����� id
	private int cnt; //��ǰ ����
	
	private int priceSum = 0; //��ǰ �հ�
	
	
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    
    public int getPriceSum() {
		return priceSum;
	}
    
    public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}
    
    @Override
    public String toString() {
        return "ProductCartDTO{" +
                "productId=" + productId +
                ", name=" + name + '\''+
                ", img='" + img + '\'' +
                ", comment='" + comment + '\'' +
                ", price=" + price +
                ", id='" + id + '\'' +
                ", cnt=" + cnt + '\'' +
                ", priceSum='" + priceSum +
                '}';
    }
	
}
