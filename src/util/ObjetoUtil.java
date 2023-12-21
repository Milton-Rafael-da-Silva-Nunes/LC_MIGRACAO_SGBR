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
    
    public final static String corrigirCpfCnpjClienteLc(String CpfCnpj) {
        if(CpfCnpj == null) {
            return "";
        } else {
           return CpfCnpj.replace(".", "").replace("/", "").replace("-", "");
        }
    }

    public final static String validarSexo(String sexo) {
        if (sexo == null) {
            return "";
        } else {
            if (sexo.equalsIgnoreCase("f")) {
                return "Feminino";
            } else if (sexo.equalsIgnoreCase("m")) {
                return "Masculino";
            } else {
                return "";
            }
        }
    }

    public final static String validarTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            return "F";
        } else {
            String tipoSemAcentos = removerAcentos(tipo.toLowerCase());
            if (tipoSemAcentos.equals("fisica")) {
                return "F";
            } else if (tipoSemAcentos.equals("juridica")) {
                return "J";
            } else {
                return null;
            }
        }
    }

    public final static String validarString(String texto) {
        if (texto == null) {
            return "";
        }
        return texto;
    }

    public final static String validarNomeFantasia(String nome, String fantasia) {
        return (fantasia != null && !fantasia.isEmpty()) ? fantasia : nome;
    }

    public final static String getObs(String tel, String cel, String fax, String obs) {
        return "TEL: " + validarString(tel)
                + "\n"
                + "CEL: " + validarString(cel)
                + "\n"
                + "FAX: " + validarString(fax)
                + "\n"
                + "OBS: " + validarString(obs)
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
    
    public static final String tamanhoObsCliente(String obs) {
        if(obs == null) {
            return "";
        } else if(obs.length()>100) {
            return obs.substring(0, 100);
        } else {
            return obs;
        }
    }
}
