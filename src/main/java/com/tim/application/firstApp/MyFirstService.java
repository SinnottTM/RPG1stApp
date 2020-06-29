package com.tim.application.firstApp;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    ProductRepository productRepository;

    public Product doSomeBigBusinessStuff(String messageFromUser){

        Product recordFromDB = productRepository.findByName(messageFromUser);

        return recordFromDB;
    }

}
