package modelforops.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import modelforops.InventoryApplication;
import modelforops.domain.OutOfStock;
import modelforops.domain.StockDecreased;
import modelforops.domain.StockIncreased;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        // StockDecreased stockDecreased = new StockDecreased(this);
        // stockDecreased.publishAfterCommit();

        // StockIncreased stockIncreased = new StockIncreased(this);
        // stockIncreased.publishAfterCommit();

        // OutOfStock outOfStock = new OutOfStock(this);
        // outOfStock.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseStock(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        StockDecreased stockDecreased = new StockDecreased(inventory);
        stockDecreased.publishAfterCommit();
        StockDecreased stockDecreased = new StockDecreased(inventory);
        stockDecreased.publishAfterCommit();
        OutOfStock outOfStock = new OutOfStock(inventory);
        outOfStock.publishAfterCommit();
        */

        // Example 2:  finding and process
        
        repository().findById(Long.valueOf(deliveryStarted.getProductId())).ifPresent(inventory->{
            
            if(inventory.getStock() >= deliveryStarted.getQty()){
                inventory.setStock(inventory.getStock() - deliveryStarted.getQty()); 
                repository().save(inventory);

                StockDecreased stockDecreased = new StockDecreased(inventory);
                stockDecreased.publishAfterCommit();

            }else{
                OutOfStock outOfStock = new OutOfStock(inventory);
                outOfStock.setOrderId(Long.valueOf(deliveryStarted.getOrderId())); 
                outOfStock.publishAfterCommit();
            }

         });
        

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(DeliveryCancelled deliveryCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        StockIncreased stockIncreased = new StockIncreased(inventory);
        stockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancelled.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            StockIncreased stockIncreased = new StockIncreased(inventory);
            stockIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
