import com.cambio.service.ConsultaCotacao;

import java.io.IOException;
import java.util.Scanner;

public class testMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConsultaCotacao consulta = new ConsultaCotacao();
        Scanner scan = new Scanner(System.in);
        String moedaBase = scan.next();
        String moedaAlvo = scan.next();


        consulta.buscaCotacao(moedaBase, moedaAlvo);
    }
}
