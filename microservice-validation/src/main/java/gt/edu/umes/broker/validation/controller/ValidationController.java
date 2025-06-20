/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.controller;

import com.google.common.hash.Hashing;
import gt.edu.umes.broker.core.model.AbstractBKModel;
import gt.edu.umes.broker.core.model.BKRequestModel;
import gt.edu.umes.broker.core.model.BKResponseModel;
import gt.edu.umes.broker.core.model.EstadoPeticion;
import gt.edu.umes.broker.core.model.MetaData;
import gt.edu.umes.broker.core.system.SFPBSystem;
import gt.edu.umes.broker.validation.service.ConnectorService;
import gt.edu.umes.broker.validation.service.LogService;
import gt.edu.umes.broker.validation.service.ValidationService;
import static gt.edu.umes.broker.validation.Validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

/**
 * Clase encargada de controlar las peticiones HTTP para las validaciones de cada
 * petición hacia los servicios externos de la organización.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/api/rest")
public final class ValidationController {
    /** Servicio de conexiones. */
    @Autowired private ConnectorService service;
    /** Servicio de validaciones. */
    @Autowired private ValidationService valService;
    /** Servicio de los logs.  */
    @Autowired private LogService logService;

    /** Un mensaje de error. */
    private String error = null;
    /** Id temporal|global*/
    private String id;

    /**
     * Método encargado de redireccionar una petición a cualquier servicio externo.
     *
     * @param model modelo|body de la petición
     * @param token toket de autorización
     * @param method método
     * @return objeto respueta
     */
    private Object requestAll(BKRequestModel model, String token, final String method) {
        if (token != null) {
            try {
                // Extraer el token Bearer
                String extractedToken = SFPBSystem.extractBearerToken(token);
                String hashToken = Hashing.sha256().hashString(extractedToken, StandardCharsets.UTF_8).toString();

                // 1. Verificar si el token está loggedOut
                if (logService.isTokenLoggedOut(hashToken)) {
                    error = "Token inválido: sesión cerrada";
                    logService.log(error, method, model.getMetaData().getEndPoint(), "none", EstadoPeticion.Pendiente);
                    
                    Object res = bkNewError(error, 401);
                    error = null;
                    return ResponseEntity.status(401).body(res);
                }

                // 2. Extraer el ID de usuario
                id = SFPBSystem.extractUsername(extractedToken, (ex) -> {
                    error = "Error al extraer datos del token: " + ex.getMessage();
                    logService.log(error, method, model.getMetaData().getEndPoint(), "none", EstadoPeticion.Pendiente);
                });

                if (id == null) {
                    Object res = bkNewError(error, 422);
                    error = null;
                    id = null;
                    return ResponseEntity.status(422).body(res);
                }

                // 3. Obtener nombre de usuario
                String nombreUsuario = logService.findUserName(id);
                if (nombreUsuario != null) {
                    MetaData metaData = model.getMetaData();
                    metaData.setClientId(id);
                    metaData.setClientName(nombreUsuario);
                }
            } catch (Exception e){
                error = "Error al procesar el token de autenticacion";
                logService.log(error + ": " + e.getMessage(), method, model.getMetaData().getEndPoint(), "none", EstadoPeticion.Pendiente);
                Object res = bkNewError(error, 500);
                error = null;
                return ResponseEntity.status(500).body(res);
            }
        }

        // Validación del modelo/servicio
        if (valService.isValid(model, (LogService logs, AbstractBKModel<Object> request, String msg, EstadoPeticion type) -> {
            if (type != EstadoPeticion.Aprobada) {
                error = "El servicio no puede ser prestado en este momento.";
            }
            logs.log(msg, method, model.getMetaData().getEndPoint(), id, type);
        })) {
            id = null;
            Object o = service.send(model);
            if (o instanceof BKResponseModel bKResponseModel) {
                return ResponseEntity.status(bKResponseModel.getBody().getStatus()).body(o);
            }
            return o;
        }

        // Manejo de error final
        Object res = bkNewError(error, 422);
        error = null;
        id = null;
        return ResponseEntity.status(422).body(res);
    }

    /**
     * Petición por el método {@code GET} con el formtado estandar.
     *
     * @param token toket de autorización
     * @param object objeto web
     * @return respueta
     */
    @GetMapping
    public Object requestGET(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String token,
            @RequestBody BKRequestModel object
    ) {
        return requestAll(object, token, "GET");
    }

    /**
     * Petición por el método {@code POST} con el formtado estandar.
     *
     * @param object objeto web
     * @param token toket de autorización
     * @return respueta
     */
    @PostMapping
    public Object requestPOST(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String token,
            @RequestBody BKRequestModel object
    ) {
        return requestAll(object, token, "POST");
    }

    /**
     * Petición por el método {@code PUT} con el formtado estandar.
     *
     * @param object objeto web
     * @param token toket de autorización
     * @return respueta
     */
    @PutMapping
    public Object requestPUT(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String token,
            @RequestBody BKRequestModel object
    ) {
        return requestAll(object, token, "PUT");
    }

    /**
     * Petición por el método {@code PATH} con el formtado estandar.
     *
     * @param object objeto web
     * @param token toket de autorización
     * @return respueta
     */
    @PatchMapping
    public Object requestPATCH(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String token,
            @RequestBody BKRequestModel object
    ) {
        return requestAll(object, token, "PATCH");
    }

    /**
     * Petición por el método {@code DELETE} con el formtado estandar.
     *
     * @param object objeto web
     * @param token toket de autorización
     * @return respueta
     */
    @DeleteMapping
    public Object requestDELETE(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String token,
            @RequestBody BKRequestModel object
    ) {
        return requestAll(object, token, "DELETE");
    }
}
