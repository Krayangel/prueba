package ecu.edu.cvds.practica.service;

import ecu.edu.cvds.practica.model.Product;

public interface StockServices {

    Product add (Product producto);
    Product update (String nameProducto, Integer units);

}
