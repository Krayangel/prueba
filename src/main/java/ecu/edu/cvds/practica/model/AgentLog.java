package ecu.edu.cvds.practica.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AgentLog implements Agent{
    private List<String> logs = new ArrayList<>();

    public AgentLog(){
    }

    public void update(Product producto){
        String mensaje = producto.getName()+": xbox one s -> " + producto.getUnits()+" unidades disponibles";
        logs.add(mensaje);
        System.out.println(mensaje);
    }

    @Override
    public List<String> getLog(){
        return logs;
    }
}
