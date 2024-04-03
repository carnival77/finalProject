package modelforops.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import modelforops.OrderApplication;
import modelforops.domain.OrderCancelled;
import modelforops.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String productId;

    private String productName;

    private Integer qty;

    private Date orderDt;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        //  Example 2:  finding and process
        
        repository().findById(Long.valueOf(deliveryStarted.getOrderId())).ifPresent(order ->{
            
            order.setStatus("DeliveryStarted");
            repository().save(order);
        });
        

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(DeliveryCancelled deliveryCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        //  Example 2:  finding and process
        
        repository().findById(Long.valueOf(deliveryCancelled.getOrderId())).ifPresent(order ->{
            
            order.setStatus("DeliveryCancelled");
            repository().save(order);
        });
        

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(OutOfStock outOfStock) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        //  Example 2:  finding and process
        
        repository().findById(Long.valueOf(outOfStock.getOrderId())).ifPresent(order ->{
            
            order.setStatus("OrderCancelled");
            repository().save(order);
        });
        

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
