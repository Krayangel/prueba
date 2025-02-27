package ecu.edu.cvds.practica.model;

import java.util.List;

public interface Agent {

    void update (Product producto);

    List<String> getLog();

}
