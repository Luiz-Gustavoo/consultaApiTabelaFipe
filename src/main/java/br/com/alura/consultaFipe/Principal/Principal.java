package br.com.alura.consultaFipe.Principal;

import br.com.alura.consultaFipe.services.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner leitor = new Scanner(System.in);
    private String endereco = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        System.out.println("Opções de veículos:\n" +
                "carros\n" +
                "motos\n" +
                "caminhoes\n");

        System.out.println("Digite o tipo de veículo que quer localizar: ");
        String tipoVeiculo = leitor.nextLine();
        System.out.println(tipoVeiculo);

        endereco = "https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo +"/marcas/";
        ConsumoApi consumoApi = new ConsumoApi();
        String retornoApi = consumoApi.consumoApi(endereco);
        System.out.println(retornoApi);
    }
}




