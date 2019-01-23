package id.koneko096.Classy.Util;

import org.slf4j.Logger;

/**
 * @author Afrizal Fikri
 */
public interface Loggable {
  default void writeLog(Logger log, String messagePlaceholder, String placeholderValue) {
    log.debug(messagePlaceholder, placeholderValue);
  }
}
