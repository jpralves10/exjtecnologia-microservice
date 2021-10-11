package br.com.exj.cadastro.service;

import br.com.exj.cadastro.entity.CheckoutEntity;
import br.com.exj.cadastro.entity.CheckoutModel;
import br.com.exj.cadastro.feign.AutenticacaoFeignClient;
import br.com.exj.cadastro.repository.ExjtecnologiaRepository;
import br.com.exj.cadastro.service.impl.ExjtecnologiaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ExjtecnologiaServiceImplTest {

    @Mock
    private ExjtecnologiaRepository repository;

    @Mock
    private AutenticacaoFeignClient feignClient;

    @InjectMocks
    private ExjtecnologiaService service = new ExjtecnologiaServiceImpl();

    private static final ResponseEntity<CheckoutModel> RESPONSE_CHECKOUT_MODEL =
            obterResponseCheckoutModel();
    private static final List<CheckoutEntity> CHECKOUT_ENTITIES = new ArrayList<>();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkoutExJTecnologia_test0(){
        when(feignClient.checkoutAutenticacao(anyString())).thenReturn(RESPONSE_CHECKOUT_MODEL);

        CheckoutEntity result = service.checkoutExJTecnologia();
        assertNotNull(result);
    }

    @Test
    public void checkoutExJTecnologia_test1(){
        when(feignClient.checkoutAutenticacao(anyString())).thenReturn(null);

        CheckoutEntity result = service.checkoutExJTecnologia();
        assertEquals(result.getStatusCheckout(), "FALHA");
    }

    @Test
    public void buscarCheckoutsExJTecnologia_test0(){
        when(repository.buscarCheckoutsPorStatus(anyString())).thenReturn(CHECKOUT_ENTITIES);

        List<CheckoutEntity> result = service.buscarCheckoutsExJTecnologia("");
        assertNotNull(result);
    }

    @Test
    public void buscarCheckoutsExJTecnologia_test1(){
        when(repository.buscarCheckoutsPorStatus(anyString())).thenReturn(null);

        List<CheckoutEntity> result = service.buscarCheckoutsExJTecnologia("");
        assertNull(result);
    }

    private static CheckoutModel obterCheckoutModel(){
        CheckoutModel checkoutModel = new CheckoutModel();
        checkoutModel.setStatusCheckout(true);
        return checkoutModel;
    }

    private static ResponseEntity<CheckoutModel> obterResponseCheckoutModel(){
        return ResponseEntity.ok(obterCheckoutModel());
    }
}
