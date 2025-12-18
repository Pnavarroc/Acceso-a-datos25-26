package org.iesch.ad.Ev1_Ej3.repository;

import org.iesch.ad.Ev1_Ej3.model.Pedido;
import org.iesch.ad.Ev1_Ej3.service.PedidoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    List<Pedido> findPedidosByLibrosTitulo(String titulo);

    List<Pedido> findPedidosByClienteNombre(String nombre);


}
