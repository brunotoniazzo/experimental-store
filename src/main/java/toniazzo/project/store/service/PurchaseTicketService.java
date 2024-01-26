package toniazzo.project.store.service;

import org.springframework.stereotype.Service;
import toniazzo.project.store.repository.PurchaseTicketRepository;

@Service
public class PurchaseTicketService {

    private final PurchaseTicketRepository purchaseTicketRepository;

    private final ProductService productService;

    public PurchaseTicketService(PurchaseTicketRepository purchaseTicketRepository, ProductService productService) {
        this.purchaseTicketRepository = purchaseTicketRepository;
        this.productService = productService;
    }

}
