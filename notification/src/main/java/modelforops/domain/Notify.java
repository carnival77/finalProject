package modelforops.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import modelforops.NotificationApplication;

@Entity
@Table(name = "Notify_table")
@Data
//<<< DDD / Aggregate Root
public class Notify {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String message;

    public static NotifyRepository repository() {
        NotifyRepository notifyRepository = NotificationApplication.applicationContext.getBean(
            NotifyRepository.class
        );
        return notifyRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifyToUser(StockIncreased stockIncreased) {
        //implement business logic here:

        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(stockIncreased.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyToUser(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyToUser(DeliveryCancelled deliveryCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancelled.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
