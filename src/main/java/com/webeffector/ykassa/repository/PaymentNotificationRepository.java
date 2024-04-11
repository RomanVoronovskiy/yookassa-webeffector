package com.webeffector.ykassa.repository;

import com.webeffector.ykassa.model.request.notification.PaymentNotification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentNotificationRepository extends MongoRepository<PaymentNotification, Long> {
}
