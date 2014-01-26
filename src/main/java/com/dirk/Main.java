package com.dirk;

import java.util.Map.Entry;
import java.util.Properties;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author dirk
 */
public class Main extends ResourceConfig {

    public Main()
    {
        packages("com.dirk");
        
        register(new AbstractBinder()
        {
            @Override
            protected void configure()
            {
                bind("woot").named("FUBAR");
            }
            
            private void _bindProperties(Properties props)
            {
                for (Entry<Object, Object> p : props.entrySet())
                    bind(p.getValue()).named((String) p.getKey());
            }
        }); 
    }
}
