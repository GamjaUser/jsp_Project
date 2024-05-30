package DTO;

public class ProductCartDTO {
	
	private int productId; //상품코드
	private String name; //상품 이름
	private String img; //상품 이미지
	private String comment; // 상품 설명
	private int price; //상품 가격
	
	private String id; //사용자 id
	private int cnt; //상품 갯수
	
	private int priceSum = 0; //삼품 합계
	
	
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
