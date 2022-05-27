
package com.example.project1.data.repositories;

import com.example.project1.data.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}