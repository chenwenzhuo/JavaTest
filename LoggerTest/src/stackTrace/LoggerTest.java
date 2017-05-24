package stackTrace;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("cn.cc.ccc");
        /*ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);*/
        logger.setLevel(Level.ALL);
        logger.severe("严重错误");
        logger.warning("警告信息");
        logger.info("普通输出");
        logger.config("配置信息");
        logger.fine("日志信息");
        logger.finer("日志信息");
        logger.finest("日志信息");
    }
}
