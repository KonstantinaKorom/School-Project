package school.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] myServletConfigurationClasses = {DispatcherServletConfiguration.class};
        return myServletConfigurationClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String[] myServletMappings = {"/"};
        return myServletMappings;
    }

}
