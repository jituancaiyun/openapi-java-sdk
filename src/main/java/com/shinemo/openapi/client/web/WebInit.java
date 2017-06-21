package com.shinemo.openapi.client.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import java.util.Map;

/**
 * Created by yuanjian on 6/20/17.
 */
public class WebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("__init_open_sdk__", new HttpServlet() {
            @Override
            public void init() throws ServletException {
                super.init();
                WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
                if (context != null) {

                    Map openApiAesKeyServlets = context.getBeansOfType(OpenApiAesKeyServlet.class);
                    if (openApiAesKeyServlets != null && !openApiAesKeyServlets.isEmpty()) {
                        OpenApiAesKeyServlet openApiAesKeyServlet = (OpenApiAesKeyServlet) openApiAesKeyServlets.values().iterator().next();
                        if (openApiAesKeyServlet != null) {
                            ServletRegistration.Dynamic registration4aesKey = servletContext.addServlet("OpenApiAesKeyServlet", openApiAesKeyServlet);
                            registration4aesKey.addMapping("/queryKey");
                        }
                    }

                    Map openApiCallbackServlets = context.getBeansOfType(OpenApiCallbackServlet.class);
                    if (openApiCallbackServlets != null && !openApiCallbackServlets.isEmpty()) {
                        OpenApiCallbackServlet openApiCallbackServlet = (OpenApiCallbackServlet) openApiCallbackServlets.values().iterator().next();
                        if (openApiCallbackServlet != null) {
                            ServletRegistration.Dynamic registration4callback = servletContext.addServlet("OpenApiCallbackServlet", openApiCallbackServlet);
                            registration4callback.addMapping("/callback");
                        }
                    }


                    System.err.println("===================================================================");
                    System.err.println("===================OPEN-API-SERVER START SUCCESS===================");
                    System.err.println("===================================================================");
                }
            }
        });
        dynamic.setLoadOnStartup(10);
    }
}
