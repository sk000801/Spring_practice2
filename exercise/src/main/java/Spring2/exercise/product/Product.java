package Spring2.exercise.product;

import Spring2.exercise.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    @Column(name="product_id")
    private Long id;
    private String ProductName;
    private int ProductPrice;
    private int stockQuantity;
    private OrderProduct kind;

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = stockQuantity - quantity;
        if(restStock<0) {
            throw new IllegalStateException("재고가 더 필요ㅠ");
        }
        this.stockQuantity = restStock;
    }
}
