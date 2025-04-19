package gt.edu.umes.broker.identity.client;

import gt.edu.umes.broker.core.Microservice;
import static gt.edu.umes.broker.core.endpoints.MCSVAdmin.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MCSV-Connector", url = Microservice.INTERNAL_MICROSERVICE_CONNECTOR + "/broker/__connection__/")
public interface AuthAdminClient {
    
    @PostMapping(HTTP_ADMIN_USUARIO_LOGIN)
    public Object validarEmpleado(@RequestBody Object object);
}
