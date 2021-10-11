package br.com.exj.cadastro.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Table do Checkout Cadastro
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="TBK1001_CHECKOUT")
public class CheckoutEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_CHECKOUT", unique = true, nullable = false)
    private Long id;

    @Column(name = "NOM_STATUS_CHECKOUT", length = 50, nullable = false)
    private String statusCheckout;

    @Column(name = "NOM_SERVICOS_DISPONIVEIS", length = 100, nullable = false)
    private String servicosDisponiveis;

    @Column(name = "DAT_DATAHORA_CHECKOUT", nullable = false)
    private LocalDateTime dataHoraCheckout;
}
