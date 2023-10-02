package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author supor
 */
public class DataHoraUtil {
    
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    
    public static String getDataHoraAtual() {
        Date dataHoraAtual = new Date();
        return sdf1.format(dataHoraAtual);
    }
    
    public static String getDataAtual() {
        Date dataHoraAtual = new Date();
        return sdf2.format(dataHoraAtual);
    }
}
