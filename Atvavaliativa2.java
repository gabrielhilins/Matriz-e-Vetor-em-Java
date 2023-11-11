/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.atvavaliativa2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author aluno
 */

// Alunos: Arthur Vinícius e Gabriel Henrique

public class Atvavaliativa2 {

    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);

        System.out.print("Digite o número inteiro de linhas e colunas da matriz: ");
        int tamanho = dado.nextInt();

        if (tamanho <= 0) {
            System.out.println("Número inválido. Digite um número inteiro positivo.");
            return; 
        }

        int[][] matriz = gerarMatrizAleatoria(tamanho, tamanho);

        System.out.println("\nMatriz Original:");
        exibeMatriz(matriz);

        System.out.println("\nMatriz com Diagonal Principal Ordenada:");
        ordenarDiagonalPrincipal(matriz);
        exibeMatriz(matriz);

        System.out.println("\nMatriz com Diagonais Principal e Secundária Ordenadas:");
        ordenarDiagonalPrincipal(matriz);
        ordenarDiagonalSecundaria(matriz);
        exibeMatriz(matriz);
    }

    public static void exibeMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] gerarMatrizAleatoria(int linhas, int colunas) {
        Random random = new Random();
        int[][] matriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = random.nextInt(1000);
            }
        }

        return matriz;
    }

    public static void ordenarDiagonalPrincipal(int[][] matriz) {
        int tamanho = matriz.length; 
      
        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < tamanho; j++) {
                if (matriz[j][j] < matriz[indiceMenor][indiceMenor]) {
                    indiceMenor = j;
                }
            }

            int temp = matriz[i][i];
            matriz[i][i] = matriz[indiceMenor][indiceMenor];
            matriz[indiceMenor][indiceMenor] = temp;
        }
    }

    public static void ordenarDiagonalSecundaria(int[][] matriz) {
        int tamanho = matriz.length;
           
        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < tamanho; j++) {
                if (matriz[j][tamanho - 1 - j] < matriz[indiceMenor][tamanho - 1 - indiceMenor]) {
                    indiceMenor = j;
                }
            }

            int temp = matriz[i][tamanho - 1 - i];
            matriz[i][tamanho - 1 - i] = matriz[indiceMenor][tamanho - 1 - indiceMenor];
            matriz[indiceMenor][tamanho - 1 - indiceMenor] = temp;
        }
    }
}


