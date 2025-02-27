package ecu.edu.cvds.practica.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecu.edu.cvds.practica.model.Agent;
import ecu.edu.cvds.practica.model.AgentLog;
import ecu.edu.cvds.practica.model.AgentWarning;
import ecu.edu.cvds.practica.model.Product;

public class StockServTest {
    private StockservImpl stockService;
    private Product Xbox;
    private Agent agentLog;
    private Agent agentWarning;

    @BeforeEach
    void setUp(){
        stockService = new StockservImpl(agentLog = new AgentLog(),agentWarning = new AgentWarning());
        Xbox = new Product("Xbox",100,20,"Consolas");
    }

    @Test
    public void shouldAddNewProduct(){
        Product auxy = stockService.add(Xbox);
        assertNotNull(auxy);
    }

    @Test
    public void shouldNotAddAExistentProduct(){
        stockService.add(Xbox);
        Product auxy = stockService.add(Xbox);
        assertNull(auxy);
    }

    @Test
    public void shouldNotAddAProductWithoutName(){
        Product auxy = stockService.add(new Product(null,20,10,"ropa"));
        assertNull(auxy);
    }

    @Test
    public void shouldNotAddAProductWithoutPrice(){
        Product auxy = stockService.add(new Product("Pantalon",null,10,"ropa"));
        assertNull(auxy);
    }

    @Test
    public void shouldNotAddAProductWithoutUnits(){
        Product auxy = stockService.add(new Product("Pantalon",20,null,"ropa"));
        assertNull(auxy);
    }

    @Test
    public void shouldNotAddAProductWithoutCategory(){
        Product auxy = stockService.add(new Product("Pantalon",20,10,null));
        assertNull(auxy);
    }


    @Test
    public void shouldUpdateAExistProductAndUpdateLogs(){
        stockService.add(Xbox);
        Product auxy = stockService.update("Xbox",3);
        assertNotNull(auxy);
        assertEquals(agentLog.getLog().get(0),"Xbox: xbox one s -> 3 unidades disponibles");
        assertEquals(agentWarning.getLog().get(0),"ALERTA!!! El stock del Producto: Xbox es muy bajo, solo quedan 3 unidades.");
    }

    @Test
    public void shouldUpdateAExistProductAndUpdateOnlyAgentLog(){
        stockService.add(Xbox);
        Product auxy = stockService.update("Xbox",20);
        assertNotNull(auxy);
        assertEquals(agentLog.getLog().get(0),"Xbox: xbox one s -> 20 unidades disponibles");
        assertEquals(agentWarning.getLog().size(),0);
    }
    @Test
    public void shouldNotUpdateAProductNotExist(){
        Product auxy = stockService.update("Carro",3);
        assertNull(auxy);
    }

    @Test
    public void shouldNotUpdateAProductIfNewUnitsIsNegative(){
        Product auxy = stockService.update("Avion",-3);
        assertNull(auxy);
    }

    @Test
    public void shouldNotUpdateAProductIfNewUnitsIsNull(){
        Product auxy = stockService.update("Avion",null);
        assertNull(auxy);
    }
}
