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
        } else if (ativo.equalsIgnoreCase("não")) {
            return "0";
        }
        return ativo;
    }

    public final static String getPodeBalanca(String balanca) {
        if (balanca.equalsIgnoreCase("s") || balanca.equals("1") || balanca.equalsIgnoreCase("sim")) {
            return "S";
        } else {
            return "N";
        }
    }

    public static String removerCaracteresEspeciais(String texto) {
        if (texto == null) {
            return "";
        }

        // Remover acentos
        texto = removerAcentos(texto);

        // Substituir caracteres não ASCII por uma string vazia
        texto = texto.replaceAll("[^\\p{ASCII}]", "");

        return texto;
    }

    public static String removerAcentos(String texto) {
        if (texto == null) {
            texto = "";
        }

        String acentuado = "çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ®";
        String semAcento = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU ";
        char[] tabela;

        tabela = new char[256];
        for (int i = 0; i < tabela.length; ++i) {
            tabela[i] = (char) i;
        }
        for (int i = 0; i < acentuado.length(); ++i) {
            tabela[acentuado.charAt(i)] = semAcento.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < texto.length(); ++i) {
            char ch = texto.charAt(i);
            if (ch < 256) {
                sb.append(tabela[ch]);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
