package br.com.alura.consultaFipe.Principal;

import br.com.alura.consultaFipe.Modelos.Marca;
import br.com.alura.consultaFipe.Modelos.Modelo;
import br.com.alura.consultaFipe.Modelos.Modelos;
import br.com.alura.consultaFipe.services.ConsumoApi;
import br.com.alura.consultaFipe.services.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitor = new Scanner(System.in);
    private String endereco = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        ConsumoApi consumoApi = new ConsumoApi();
        ConverteDados converteDados = new ConverteDados();

        System.out.println("Opções de veículos:\n" +
                "carros\n" +
                "motos\n" +
                "caminhoes\n");

        System.out.println("Digite o tipo de veículo que quer localizar: ");
        String tipoVeiculo = leitor.nextLine();

        endereco = "https://parallelum.com.br/fipe/api/v1/"+tipoVeiculo+"/marcas/";
        String listaMarcas = consumoApi.consumoApi(endereco);

         Marca[] listaMarcasConvertida = converteDados.converteDados(listaMarcas, Marca[].class);
        System.out.println("Lista de marcas de " + tipoVeiculo+"\n");
        for(Marca marca: listaMarcasConvertida){
            System.out.println(
                    "Código: " + marca.codigo() + ", " + "Nome: " + marca.nome());
        }

        System.out.println("\nEscolha uma marca para consulta");
        String codMarca = leitor.nextLine();

        endereco = "https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo+"/marcas"+"/"+codMarca+"/modelos/";
        String listaModelos = consumoApi.consumoApi(endereco);

       Modelos listaModelosConvertida = converteDados.converteDados(listaModelos, Modelos.class);
        System.out.println("\nLista de modelos da marca de código " + codMarca);
       List<Modelo> listaModelo = listaModelosConvertida.modelos();
       for(Modelo modelo: listaModelo){
           System.out.println(
                   "Código: " + modelo.codigo() + ", " + "Nome: "+ modelo.nome());
       }

        System.out.println("\nDigite o nome do modelo que deseja buscar");
       String modeloSolicitado = leitor.nextLine();

        System.out.println("\nLista de modelos solicitados");
       List<Modelo> listaModeloSolicitado = listaModelo.stream()
               .filter(modelo -> modelo.nome().toLowerCase().contains(modeloSolicitado))
               .collect(Collectors.toList());

        for(Modelo modelo: listaModeloSolicitado){
            System.out.println(
                    "Código: " + modelo.codigo() + ", " + "Nome: "+ modelo.nome());
        }
    }
}




