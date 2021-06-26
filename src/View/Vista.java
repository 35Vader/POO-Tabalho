package View;

import java.io.Serializable;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;
import java.util.Locale;

public class Vista implements IVista, Serializable {
    public Vista() {
    }

    private void header() {
        System.out.printf("\n" +
                "-------------------------------------------------\n" +
                "|              FOOTBALL MANAGER                 |\n" +
                "-------------------------------------------------\n"
        );
    }

    private void personalizedHeader(String header) {
        int spaces = (48 - header.length())/2;
        int spaces2 = 48 - spaces - header.length();
        System.out.printf("\n--------------------------------------------------\n|");
        System.out.printf(printSpaces(spaces));
        System.out.printf(header.toUpperCase(Locale.ROOT));
        System.out.printf(printSpaces(spaces2));
        System.out.printf("|\n--------------------------------------------------\n");
    }

    private String printSpaces(int a){
        String str = "";
        for(int i=0;i<a;i++){
            str += " ";
        }
        return str;
    }


    public void menuInicial() {
        header();
        System.out.printf("1. Transferências\n" +
                          "2. Consultar Jogadores ou Equipas\n" +
                          "3. Simular Jogo\n" +
                          "4. Simular Liga\n" +
                          "5. Guardar estado\n" +
                          "6. Carregar estado\n" +
                          "0. Sair\n\n");
    }

    public void menuTransferências() {
        personalizedHeader("Transferências");
        System.out.printf(
                "1. Histórico transferências\n" +
                "2. Efetuar transferência\n" +
                "0. Voltar\n\n");
    }

    public void menuConsulta() {
        personalizedHeader("Equipas|Jogadores");
        System.out.printf(
                        "1. Consultar equipa\n" +
                        "2. Consultar jogador\n" +
                        "3. Top jogadores\n" +
                        "4. Top equipas\n" +
                        "0. Voltar\n\n");
    }

    public void printJogador(String posicao, String id, String nome, List<String> historial, String velocidade, String resistencia,
                             String impulsao, String destreza, String cabeca, String remate, String passe,String eq, String pont){


        personalizedHeader(nome);
        System.out.printf(posicao.toUpperCase(Locale.ROOT) + "\n\n");
        final Object[][] table = new String[4][];
        table[0] = new String[] { "Velocidade " + velocidade, "Resistência " + resistencia };
        table[1] = new String[] { "Impulsão " + impulsao , "Destreza " + destreza};
        table[2] = new String[] { "Cabeca " + cabeca, "Remate " + remate};
        table[3] = new String[] { "Remate " + remate, "Passe " + passe};

        for (final Object[] row : table)
            System.out.format("%15s %15s%n", row);

        System.out.printf("\nEquipa Atual:" + eq);
        System.out.printf("\nHISTORIAL \n");
        for(String e: historial)
            System.out.printf(e + "\n");
    }

    public void printEquipa(String e){
        System.out.println(e);
    }

    public void pedirJogador() {
        System.out.printf("Insira um jogador: ");
    }

    public void pedirEquipa() {
        System.out.printf("Insira uma equipa: ");
    }

    public void pedirOpcao() {
        System.out.printf("Insira uma opção: ");
    }
}
