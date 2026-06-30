package br.com.anotaai.repository;

import br.com.anotaai.entity.Pedido;
import br.com.anotaai.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}
