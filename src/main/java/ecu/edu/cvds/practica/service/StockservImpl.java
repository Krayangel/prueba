package ecu.edu.cvds.practica.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ecu.edu.cvds.practica.model.Agent;
import ecu.edu.cvds.practica.model.Product;

@Service
public class StockservImpl implements StockServices{
    private Map<String,Product>products = new HashMap<>();
    private final Agent agentLog;
    private final Agent agentWarning;
    public StockservImpl(@Qualifier("agentLog") Agent agentLog,@Qualifier("agentWarning") Agent agentWarning){
        this.agentLog=agentLog;
        this.agentWarning=agentWarning;
    }

    @Override
    public Product add(Product producto) {
        if(products.containsKey(producto.getName())){
            return null;
        }
        if(!verifyProduct(producto)){
            return null;
        }
        products.put(producto.getName(),producto);
        return(producto);
    }

    @Override
    public Product update(String nameProduct,Integer newUnits) {
        Product producto = products.get(nameProduct);
        if(producto == null || newUnits == null || newUnits < 0){
            return null;
        }
        producto.setUnits(newUnits);
        products.put(producto.getName(),producto);
        updateAgents(producto);
        return producto;
    }

    private boolean verifyProduct(Product producto){
        if(producto.getName() == null || producto.getUnits() == null || producto.getCategory() == null|| producto.getPrice()==null){
            return false;
        }
        return true;
    }

    private void updateAgents(Product product){
        agentWarning.update(product);
        agentLog.update(product);
    }

}
