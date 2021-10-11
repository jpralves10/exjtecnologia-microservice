package br.com.exj.cadastro.controller;

import br.com.exj.cadastro.entity.CheckoutEntity;
import br.com.exj.cadastro.service.ExjtecnologiaService;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableWebMvc
public class ExjtecnologiaControllerTest {

    @Mock
    private ExjtecnologiaService exjtecnologiaService;

    @InjectMocks
    private ExjtecnologiaController exjtecnologiaController;

    private MockMvc mockMvc;

    private static final CheckoutEntity CHECKOUT_ENTITY = new CheckoutEntity();
    private static final List<CheckoutEntity> CHECKOUT_ENTITIES = new ArrayList<>();

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.exjtecnologiaController).build();
    }

    @Test
    public void getExJTecnologia_test0() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/v1/exjtecnologia/ola"))
                        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.SC_OK)).andReturn();
    }

    @Test
    public void checkoutExJTecnologia_test0() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/v1/exjtecnologia/checkout"))
                        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.SC_OK)).andReturn();
    }

    @Test
    public void checkoutExJTecnologiaServicos_test0() throws Exception {
        when(exjtecnologiaService.checkoutExJTecnologia()).thenReturn(CHECKOUT_ENTITY);

        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/v1/exjtecnologia/checkout/servicos"))
                        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.SC_OK)).andReturn();
    }

    @Test
    public void checkoutExJTecnologiaServicos_test1() throws Exception {
        when(exjtecnologiaService.checkoutExJTecnologia()).thenReturn(null);

        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/v1/exjtecnologia/checkout/servicos"))
                        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.SC_NO_CONTENT)).andReturn();
    }

    @Test
    public void buscarCheckoutsExJTecnologia_test0() throws Exception {
        when(exjtecnologiaService.buscarCheckoutsExJTecnologia(anyString())).thenReturn(CHECKOUT_ENTITIES);

        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/v1/exjtecnologia/checkout/1"))
                        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.SC_OK)).andReturn();
    }

    @Test
    public void buscarCheckoutsExJTecnologia_test1() throws Exception {
        when(exjtecnologiaService.buscarCheckoutsExJTecnologia(anyString())).thenReturn(null);

        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/v1/exjtecnologia/checkout/1"))
                        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.SC_NO_CONTENT)).andReturn();
    }
}
