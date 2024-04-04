package modelforops.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import modelforops.ReviewApplication;
import modelforops.domain.ReviewWritten;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String productId;

    private String productName;

    private String comment;

    private Date orderDt;

    private Date deliveryDt;

    private String address;

    @PostPersist
    public void onPostPersist() {
        ReviewWritten reviewWritten = new ReviewWritten(this);
        reviewWritten.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    //<<< Clean Arch / Port Method
    public static void writeReview(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        ReviewWritten reviewWritten = new ReviewWritten(review);
        reviewWritten.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);

            ReviewWritten reviewWritten = new ReviewWritten(review);
            reviewWritten.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
