package toniazzo.project.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toniazzo.project.store.entity.PurchaseTicket;

@Repository
public interface PurchaseTicketRepository extends JpaRepository<PurchaseTicket, Long> {
}
