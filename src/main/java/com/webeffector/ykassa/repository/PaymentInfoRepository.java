package com.webeffector.ykassa.repository;

import com.webeffector.ykassa.model.response.PaymentCreateResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepository extends MongoRepository<PaymentCreateResponse, String> {
}



