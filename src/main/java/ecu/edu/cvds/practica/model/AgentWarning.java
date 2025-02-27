package ecu.edu.cvds.practica.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AgentWarning implements Agent{
    private List<String> logs = new ArrayList<>();

    public AgentWarning(){
    }
    public void update(Product producto) {
        if (producto.getUnits()<5){
            String mensaje = "ALERTA!!! El stock del Producto: "+producto.getName()+" es muy bajo, solo quedan "+ (producto.getUnits()) +" unidades.";
            logs.add(mensaje);
            System.out.println(mensaje);
        }
    }

    @Override
    public List<String> getLog(){
        return logs;
    }
}
