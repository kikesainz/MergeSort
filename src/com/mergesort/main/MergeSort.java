package com.mergesort.main;

public class MergeSort {
	public static void mergeSort(int[] arr) {

		int middle = arr.length / 2;

		// Dividir el array en dos mitades
		int[] izquierdo = new int[middle];
		int[] derecho = new int[arr.length - middle];

		for (int i = 0; i < middle; i++) {
			izquierdo[i] = arr[i];
		}
		for (int i = middle; i < arr.length; i++) {
			derecho[i - middle] = arr[i];
		}

		// Llamadas recursivas para ordenar ambas mitades
		mergeSort(izquierdo);
		mergeSort(derecho);

		// Combinar las mitades ordenadas
		fusionarArrays(arr, izquierdo, derecho);

	}

	public static void fusionarArrays(int[] arr, int[] arrayIzquierdo, int[] arrayDerecho) {
		int i = 0, j = 0, k = 0;

		// Combinar las dos mitades ordenadas en el array original
		while (i < arrayIzquierdo.length && j < arrayDerecho.length) {
			if (arrayIzquierdo[i] < arrayDerecho[j]) {
				arr[k++] = arrayIzquierdo[i++];
			} else {
				arr[k++] = arrayDerecho[j++];
			}
		}

		// Copiar los elementos restantes de arrayIzquierdo[] y arrayDerecho[] si los hay
		while (i < arrayIzquierdo.length) {
			arr[k++] = arrayIzquierdo[i++];
		}
		while (j < arrayDerecho.length) {
			arr[k++] = arrayDerecho[j++];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 38, 27, 43, 3, 9, 82, 10 };

		System.out.println("Array desordenado:");
		for (int num : arr) {
			System.out.print(num + " ");
		}

		mergeSort(arr);

		System.out.println("\nArray ordenado:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}
