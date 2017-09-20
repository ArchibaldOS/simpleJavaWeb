package org.smart4j.framework.help;

import java.util.Properties;
import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropsUtil;
/**
 * @author Archibald
 * @version:
 * @time: 6/22/2017.
 */
public final class ConfigConstant {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
    
    public static String getJdbcDriver(){
        return PropsUtil
    }
}
