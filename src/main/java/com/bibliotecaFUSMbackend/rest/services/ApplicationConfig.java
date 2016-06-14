package com.bibliotecaFUSMbackend.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author usuario
 */

@ApplicationPath("webresources")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("com.bibliotecaFUSMbackend.rest.services;com.bibliotecaFUSMbackend.rest.auth");
//        register (RolesAllowedDynamicFeature.class);
    }
}
