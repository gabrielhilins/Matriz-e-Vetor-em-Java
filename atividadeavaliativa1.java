/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.atividadeavaliativa1;

/**
 *
 * @author aluno
 */
import static java.lang.Math.random;
import java.util.Arrays;
import java.util.Random;

public class Atividadeavaliativa1 {
    // Alunos: Arthur Vinícius e Gabriel Henrique

    public static void main(String[] args) {
        int[] A = criarVetorAleatorio(100000, 256);
        int[] B = criarVetorAleatorio(100000, 256);

        ordenarVetor(A);
        ordenarVetor(B);

        long tempoInicio = System.currentTimeMillis();
        int[] C = intercalarVetores(A, B);
        long tempoFim = System.currentTimeMillis();
        long tempoExecucao = tempoFim - tempoInicio;

        System.out.println("Vetor C: " + Arrays.toString(C));
        System.out.println("Tempo de execução do método intercalarVetores: " + tempoExecucao + " milissegundos");
    }

    public static int[] criarVetorAleatorio(int tamanho, int intervalo) {
        Random random = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(intervalo + 1);
        }
        return vetor;
    }

    public static int[] ordenarVetor(int[] vet) {
        int i, j, menor, aux;
        for (i = 0; i < vet.length - 1; i++) {
            menor = i;
            for (j = i + 1; j <= vet.length - 1; j++) {
                if (vet[j] < vet[menor]) {
                    menor = j;
                }
            }
            aux = vet[i];
            vet[i] = vet[menor];
            vet[menor] = aux;
        }
        return vet;
    }

    public static int[] intercalarVetores(int[] A, int[] B) {
        int tamanhoC = A.length + B.length;
        int[] C = new int[tamanhoC];
        int i = 0, j = 0, k = 0;

        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while (i < A.length) {
            C[k++] = A[i++];
        }

        while (j < B.length) {
            C[k++] = B[j++];
        }

        return C;
    }

}
