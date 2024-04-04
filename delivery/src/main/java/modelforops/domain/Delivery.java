package modelforops.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import modelforops.DeliveryApplication;
import modelforops.domain.DeliveryCancelled;
import modelforops.domain.DeliveryStarted;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String userId;

    private String productId;

    private String productName;

    private Integer qty;

    private String status;

    private Date delieveryDt;

    @PostUpdate
    public void onPostUpdate() {
        // DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        // deliveryStarted.publishAfterCommit();

        // DeliveryCancelled deliveryCancelled = new DeliveryCancelled(this);
        // deliveryCancelled.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        //implement business logic here:

        //  Example 1:  new item 
        Delivery delivery = new Delivery();
        delivery.setQty(orderPlaced.getQty());
        delivery.setProductId(orderPlaced.getProductId());
        delivery.setProductName(orderPlaced.getProductName());
        delivery.setOrderId(orderPlaced.getId());
        delivery.setStatus("Delivery Started");
        repository().save(delivery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
        deliveryStarted.publishAfterCommit();
        

        // Example 2:  finding and process
        
        // repository().findById(Long.valueOf(orderPlaced.getId())).ifPresent(delivery->{
            
            // inventory.setStock(inventory.getStock() - orderPlaced.getQty()); // do something
            // repository().save(delivery);

            // DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
            // deliveryStarted.set
            // deliveryStarted.setQty(orderPlaced.getQty());
            // deliveryStarted.publishAfterCommit();

            // Delivery delivery = new Delivery();
            // delivery.setQty(orderPlaced.getQty());
            // delivery.setProductId(orderPlaced.getProductId());
            // delivery.setOrderId(orderPlaced.getId());
            // repository().save(delivery);

            // DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
            // deliveryStarted.publishAfterCommit();

        //  });
        

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCancelled orderCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(delivery);
        deliveryCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryCancelled deliveryCancelled = new DeliveryCancelled(delivery);
            deliveryCancelled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
