package demo.Repository;

import demo.Model.cuentaBancaria;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by nilpanescoll on 01/10/15.
 */
public interface cuentaBancariaRepository extends PagingAndSortingRepository<cuentaBancaria, Long> {
}
