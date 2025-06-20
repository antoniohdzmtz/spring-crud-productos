package com.example.crud_productos;

import com.example.crud_productos.controller.ProductController;
import com.example.crud_productos.entity.Product;
import com.example.crud_productos.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private ProductService productoService;

    @Test
    public void testListarProductos() throws Exception {
        // Simula respuesta del servicio
        Product producto = new Product();
        producto.setNombre("Prueba");
        producto.setDescripcion("Producto de prueba");
        producto.setStock(10);
        producto.setFecha(new Date());

        when(productoService.getAllProducts()).thenReturn(List.of(producto));

        mockMvc.perform(get("/product"))
                .andExpect(status().isOk());
    }
}
