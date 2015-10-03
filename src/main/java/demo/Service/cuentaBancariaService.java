package demo.Service;

import demo.Model.cuentaBancaria;
import demo.Repository.cuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Created by nilpanescoll on 01/10/15.
 */
@Service
@Transactional
public class cuentaBancariaService {

    @Autowired
    private cuentaBancariaRepository cuentabancariaRepository;

    public void ingreso(Long idCuentaBancaria, Double cantidad){
        cuentaBancaria cuentaBancaria = cuentabancariaRepository.findOne(idCuentaBancaria);
        cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() + cantidad);
        cuentabancariaRepository.save(cuentaBancaria);
    }

    public void reintegro (Long idCuentaBancaria, Double cantidad){
        cuentaBancaria cuentaBancaria = cuentabancariaRepository.findOne(idCuentaBancaria);
        cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() - cantidad);
        cuentabancariaRepository.save(cuentaBancaria);
    }

    public void traspaso (Long idCuentaBancariaOrigen, Long idCuentaBancariaDestino, Double cantidad){
        cuentaBancaria cuentaBancariaOrigen = cuentabancariaRepository.findOne(idCuentaBancariaOrigen);
        cuentaBancaria cuentaBancariaDestino = cuentabancariaRepository.findOne(idCuentaBancariaDestino);
        cuentaBancariaOrigen.setSaldo(cuentaBancariaOrigen.getSaldo() - cantidad);
        cuentaBancariaDestino.setSaldo(cuentaBancariaDestino.getSaldo() + cantidad);
        cuentabancariaRepository.save(cuentaBancariaOrigen);
        cuentabancariaRepository.save(cuentaBancariaDestino);
    }
}
