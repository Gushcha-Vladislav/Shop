package com.tsystems.javaschoolshop.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import com.tsystems.javaschoolshop.listener.SessionListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Application initializer which registers dispatcher servlet
 * and some other important settings.
 * It also registers our custom configs for this web application.
 * For example, WebConfig {@link WebConfig}
 *              SecurityConfig {@link SecurityConfig}
 *              JmsConfig {@link JmsConfig}
 */
public class AppInitializer implements WebApplicationInitializer {

    /**
     * Method we had to implement for correct working of out application.
     * In Method we set all settings. See description of the class above.
     * @param container - context of the application
     * @throws ServletException in some cases when our settings isn't correct
     */
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        ctx.register(SecurityConfig.class);
        ctx.register(JmsConfig.class);
        container.addListener(new ContextLoaderListener(ctx));
        container.addListener(new SessionListener());

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setAsyncSupported(true);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        FilterRegistration.Dynamic encodingFilter = container.addFilter("encoding-filter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");}
}
