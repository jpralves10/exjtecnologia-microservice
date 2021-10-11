package br.com.exj.cadastro.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveMQModel implements Serializable {

    private static final long serialVersionUID = -295422703255886286L;

    private String user;
    private String tipo; //fila ou topico
}
