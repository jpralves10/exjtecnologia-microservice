package br.com.exj.cadastro.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutModel {

    private Boolean statusCheckout;
    private LocalDateTime dataHoraCheckout;
}
