package com.reading.core.Util;

import com.reading.core.Exeptions.CSVFormatException;
import com.reading.core.classes.*;

public class GeradorEmpregado {
    public static Funcionario gerarFuncionario(String line) {
        try {
            line = line.replaceAll(" ", "");

            String[] informations = new String[line.split(";").length];
            informations = line.split(";");

            if (informations[0].equals("1")) {
                Chefe chefe = new Chefe(
                        (informations[2]), Integer.parseInt(informations[1]),
                        Double.parseDouble(informations[3]), Double.parseDouble(informations[4]),
                        Double.parseDouble(informations[5])
                );
                return chefe;
            } else if (informations[0].equals("2")) {
                Comissionado comissionado = new Comissionado(
                        informations[2], Integer.parseInt(informations[1]),
                        Double.parseDouble(informations[3]), Double.parseDouble(informations[4])
                );
                return comissionado;
            } else if (informations[0].equals( "3")) {
                Horista horista = new Horista(
                        informations[2], Integer.parseInt(informations[1]),
                        Double.parseDouble(informations[4]), Integer.parseInt(informations[3])
                );
                return horista;
            } else if (informations[0].equals("4")) {
                Empreiteiro empreiteiro = new Empreiteiro(
                        informations[2], Integer.parseInt(informations[1]),
                        Double.parseDouble(informations[3])
                );
                return empreiteiro;
            }

            throw new CSVFormatException("Erro no formato do arquivo");
        } catch (Exception e) {
            throw new CSVFormatException("Erro ao cadastrar funcionario " + e.getMessage());
        }
    }

}
