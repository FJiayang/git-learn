package top.fjy8018.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 过滤器
 * @author F嘉阳
 * @date 2019/12/3 17:28
 */
@Plugin(name = "MsgFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
public class MsgFilter extends AbstractFilter {

    private static Logger log = LoggerFactory.getLogger(MsgFilter.class);

    private static final Integer MAX_LENGTH = 1000;

    private MsgFilter(Result onMatch, Result onMismatch) {
        super(onMatch, onMismatch);
    }

    @PluginFactory
    public static MsgFilter createFilter(@PluginAttribute("onMatch") final Result match,
                                         @PluginAttribute("onMismatch") final Result mismatch) {
        return new MsgFilter(match, mismatch);
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, Level level, Marker marker, Message msg, Throwable t) {
        return filter(logger, level, marker, msg, t);
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, Level level, Marker marker, String msg, Object... params) {
        if (msg.length() > MAX_LENGTH){
            msg = msg.substring(0,MAX_LENGTH);
            log.info("新日志： {}",msg);
            return onMismatch;
        }
        return onMatch;
    }
}
