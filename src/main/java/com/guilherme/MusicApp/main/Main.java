package com.guilherme.MusicApp.main;

import com.guilherme.MusicApp.models.Artista;
import com.guilherme.MusicApp.models.Tipo;
import com.guilherme.MusicApp.repository.Repository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Repository repository;
    Scanner scanner = new Scanner(System.in);

    public Main(Repository repository){
        this.repository = repository;
    }

    public void main() {
        System.out.println(" == MENU ==");
        System.out.println(" 1 - Cadastrar artistas");
        System.out.println(" 2 - Cadastrar musicas");
        System.out.println(" 3 - Listar musicas");
        System.out.println(" 4 - Buscar musica por artista");
        System.out.println(" 5 - Buscar informações sobre artista");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao) {
            case 1:
                cadastrarArtista();
                break;
            case 2:
                cadastrarMusica();
                break;
        }
        System.out.println("\n 0 - Sair\n");
    }

    private void cadastrarArtista() {
        System.out.println("Qual nome do artista?");
        String nome = scanner.nextLine();
        System.out.println("Qual tipo de artista? Solo, duo ou banda?");
        String categoria = scanner.nextLine();
        Tipo tipo = Tipo.qualTipo(categoria);
        Artista artista = new Artista(nome, tipo);
        repository.save(artista);
    }

    private void cadastrarMusica() {
        System.out.println("Qual desses artistas voce deseja procurar?");
        repository.findAll().stream().forEach(e -> System.out.println(e.getNome()));
        System.out.println("Qual nome da musica?");
        String nome = scanner.nextLine();
        System.out.println("Qual o album?");
        String album = scanner.nextLine();
        System.out.println("Qual o artista? ");
    }
}
