package br.com.exj.cadastro.repository;

import br.com.exj.cadastro.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository do Checkout Cadastro
 * usa a tabela TBK1001_CHECKOUT_EXJTECNOLOGIA
 */
@Repository
public interface ExjtecnologiaRepository extends JpaRepository<CheckoutEntity, Long> {

    @Query(value = "SELECT * FROM TBK1001_EXJTECNOLOGIA WHERE " +
            "NOM_STATUS_CHECKOUT = :statusCheckout", nativeQuery = true)
    List<CheckoutEntity> buscarCheckoutsPorStatus(
            @Param("statusCheckout") String statusCheckout);
}
