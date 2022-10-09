package pro.goforit.common.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 9:50
 * @desc:
 **/
public class LogBackColorConfig extends ForegroundCompositeConverterBase<ILoggingEvent> {
    @Override
    protected String getForegroundColorCode(ILoggingEvent iLoggingEvent) {
        Level level = iLoggingEvent.getLevel();
        return switch (level.toInt()) {
            //ERROR等级为红色
            case Level.ERROR_INT -> ANSIConstants.RED_FG;
            //WARN等级为黄色
            case Level.WARN_INT -> ANSIConstants.YELLOW_FG;
            //INFO等级为蓝色
            case Level.INFO_INT -> ANSIConstants.BLUE_FG;
            //DEBUG等级为绿色
            case Level.DEBUG_INT -> ANSIConstants.GREEN_FG;
            //其他为默认颜色
            default -> ANSIConstants.DEFAULT_FG;
        };

        }
}
