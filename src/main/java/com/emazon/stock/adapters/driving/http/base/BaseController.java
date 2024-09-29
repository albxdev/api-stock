package com.emazon.stock.adapters.driving.http.base;

import org.springframework.http.HttpHeaders;

import java.util.Base64;


public class BaseController {

    protected boolean isAuthorized(HttpHeaders headers) {
        String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return false;
        }

        // Extraer las credenciales codificadas en Base64
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        String[] values = credentials.split(":", 2);

        // Validar que se hayan proporcionado ambos valores
        if (values.length != 2) {
            return false;
        }

        String username = values[0];
        String password = values[1];

        // Aquí deberías comprobar las credenciales de manera más segura
        return "admin".equals(username) && "password".equals(password); // Cambia esto según tus credenciales
    }
}
