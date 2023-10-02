package util;

/**
 *
 * @author supor
 */
public class ObjetoUtil {

    public final static String validarCpfCnpj(String cpf, String cnpj) {
        if (cpf == null) {
            cpf = "";
        }
        if (cnpj == null) {
            cnpj = "";
        }
        return cpf.isEmpty() ? cnpj : cpf;
    }

    public final static String validarString(String texto) {
        if (texto == null) {
            return "";
        }
        return texto;
    }

    public final static String getObs(String tel, String cel, String fax) {
        return "TEL: " + validarString(tel)
                + "\n"
                + "CEL: " + validarString(cel)
                + "\n"
                + "FAX: " + validarString(fax)
                + "\n"
                + "MIGRADO: " + DataHoraUtil.getDataAtual();
    }

    public final static String getAtivo(String ativo) {
        if (ativo.equalsIgnoreCase("s")) {
            return "1";
        } else if (ativo.equalsIgnoreCase("sim")) {
            return "1";
        } else if (ativo.equalsIgnoreCase("n")) {
            return "0";
        } else if (ativo.equalsIgnoreCase("nao")) {
            return "0";
        }
        return ativo;
    }

    public final static String getPodeBalanca(String balanca) {
        if (balanca == null || balanca.equals("") || balanca.equals("0") || balanca.equalsIgnoreCase("nao")) {
            return "N";
        } else {
            return "S";
        }
    }

}
