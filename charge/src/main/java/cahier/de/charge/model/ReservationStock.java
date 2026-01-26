package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class ReservationStock implements Serializable {
    private Integer id;
    private Integer commandeClientId;
    private Integer articleId;
    private Integer lotId;
    private BigDecimal quantiteReservee;
    private Timestamp dateReservation;

    public ReservationStock() {}

    public ReservationStock(Integer id, Integer commandeClientId, Integer articleId, Integer lotId, 
                            BigDecimal quantiteReservee, Timestamp dateReservation) {
        this.id = id;
        this.commandeClientId = commandeClientId;
        this.articleId = articleId;
        this.lotId = lotId;
        this.quantiteReservee = quantiteReservee;
        this.dateReservation = dateReservation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getCommandeClientId() { return commandeClientId; }
    public void setCommandeClientId(Integer commandeClientId) { this.commandeClientId = commandeClientId; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public Integer getLotId() { return lotId; }
    public void setLotId(Integer lotId) { this.lotId = lotId; }
    
    public BigDecimal getQuantiteReservee() { return quantiteReservee; }
    public void setQuantiteReservee(BigDecimal quantiteReservee) { this.quantiteReservee = quantiteReservee; }
    
    public Timestamp getDateReservation() { return dateReservation; }
    public void setDateReservation(Timestamp dateReservation) { this.dateReservation = dateReservation; }
}