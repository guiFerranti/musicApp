package com.guilherme.MusicApp.main;

import com.guilherme.MusicApp.models.Artista;
import com.guilherme.MusicApp.models.Musica;
import com.guilherme.MusicApp.models.Tipo;
import com.guilherme.MusicApp.repository.ArtistRepository;
import com.guilherme.MusicApp.repository.MusicRepository;
import com.guilherme.MusicApp.services.ChatGpt;

import java.util.List;
import java.util.Scanner;

public class Main {
    private ArtistRepository artistRepository;
    private MusicRepository musicRepository;
    Scanner scanner = new Scanner(System.in);

    public Main(ArtistRepository artistRepository, MusicRepository musicRepository){
        this.artistRepository = artistRepository;
        this.musicRepository = musicRepository;
    }

    public void main() {
        int opcao = -1;
        while (opcao != 0) {

            String menu = """
                    ==== MENU ====
                     1 - Cadastrar artistas
                     2 - Cadastrar musicas
                     3 - Listar musicas
                     4 - Buscar musica por artista
                     5 - Buscar informações sobre artista
                    \n 0 - Sair
                    """;
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                case 5:
                    buscarInformacoesDoArtista();
            }
        }
    }

    private void cadastrarArtista() {
        System.out.println("Qual nome do artista?");
        String nome = scanner.nextLine();
        System.out.println("Qual tipo de artista? Solo, duo ou banda?");
        String categoria = scanner.nextLine();
        Tipo tipo = Tipo.qualTipo(categoria);
        Artista artista = new Artista(nome, tipo);
        artistRepository.save(artista);
    }

    private void cadastrarMusica() {
        System.out.println("Artistas ja cadastrados: ");
        artistRepository.findAll().stream().forEach(e -> System.out.println(e.getNome()));
        System.out.println("Qual desses artistas voce deseja cadastrar uma musica?");
        String nomeArtista = scanner.nextLine();

        Artista artista = artistRepository.acharArtista(nomeArtista);

        System.out.println("Qual nome da musica?");
        String nome = scanner.nextLine();
        System.out.println("Qual o album?");
        String album = scanner.nextLine();
        System.out.println("Qual o artista? ");
        Musica musica = new Musica(nome, album, artista);
        musicRepository.save(musica);
    }

    private void listarMusicas() {
        System.out.println("Todas musicas salvas divididas por artista:");
        List<Musica> musicas = musicRepository.todasAsMusicas();
        System.out.println(musicas);
        musicas.forEach(m -> System.out.println("Artista: " + m.getArtista().getNome() + " - " + "Album: " + m.getAlbum() + " - " + m.getNome()));
    }

    private void buscarMusicaPorArtista() {
        Artista artist =  selecionarArtistas();
        System.out.println("Qual o nome da musica?");
        String nomeMus = scanner.nextLine();
//        List<Musica> musicas = musicRepository.musicasPorArtista(artist.getId());
//        musicas.forEach(m -> System.out.println("Album - " + m.getAlbum() + " - " + m.getNome()));
        Musica musica = musicRepository.musicaPorNomeArtista(nomeMus, artist.getId());
        System.out.println(musica.getAlbum() + " - " + musica.getNome());
    }

    private void buscarInformacoesDoArtista(){
        Artista artist = selecionarArtistas();

        String info = ChatGpt.infoArtista(artist.getNome());
        System.out.println(info);
    }

    private Artista selecionarArtistas(){
        List<Artista> artistas = artistRepository.findAll();
        artistas.forEach(a -> System.out.println("Artista: " + a.getNome()));
        System.out.println("\nQual artista voce escolhe?");
        String artista = scanner.nextLine();
        Artista artist = artistRepository.acharArtista(artista);
        return artist;
    }

}
