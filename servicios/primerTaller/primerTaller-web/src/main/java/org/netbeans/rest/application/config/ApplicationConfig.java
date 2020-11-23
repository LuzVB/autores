/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Valentina
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(edu.unicundi.controller.AutorController.class);
        resources.add(edu.unicundi.controller.CursoController.class);
        resources.add(edu.unicundi.controller.LibroController.class);
        resources.add(edu.unicundi.controller.MateriaController.class);
        resources.add(edu.unicundi.controller.ProfesorController.class);
        resources.add(edu.unicundi.exception.filter.ConstraintViolationFilter.class);
        resources.add(edu.unicundi.exception.filter.CorsFilter.class);
        resources.add(edu.unicundi.exception.filter.EJBExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.ExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.HttpResponseExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.IdVacioExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.ListaVaciaExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.NoValidoExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.NotFoundExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.NullPointerExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.ObjectNotFoundExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.ParamRequiredExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.ParamUsedExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.SQLExceptionFilter.class);
        resources.add(edu.unicundi.exception.filter.WebApplicationExceptionFilter.class);
    }
    
}
