package com.microservices.consumer.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.consumer.domain.Invoice;
import com.microservices.consumer.repositories.InvoiceRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceListener {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = Constants.INVOICE_QUEUE_NAME)
    public void listen(String in) {
        System.out.println("Message read from "+ Constants.INVOICE_QUEUE_NAME+" : " + in);
        try {
            Invoice invoice = objectMapper.readValue(in, Invoice.class);
            invoiceRepository.save(invoice);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
