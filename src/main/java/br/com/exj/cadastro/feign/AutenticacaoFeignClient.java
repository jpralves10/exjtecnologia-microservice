package br.com.exj.cadastro.feign;

import br.com.exj.cadastro.entity.CheckoutModel;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="${feignClient.autenticacao.name}", url="${feignClient.autenticacao.host}")
public interface AutenticacaoFeignClient {

    @RequestMapping(method=RequestMethod.GET, value="/v1/autenticacao/checkout", consumes="application/json")
    @Headers("Content-Type: application/json")
    ResponseEntity<CheckoutModel> checkoutAutenticacao(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    );
}
