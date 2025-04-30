package Metodos;

import Implementaciones.Heap;

public class TestHeap {
    public static void main(String[] args) {
        Heap heap = new Heap();

        System.out.println("¿Heap vacío? " + heap.isEmpty());

        heap.insert(1);
        heap.insert(4);
        heap.insert(5);
        heap.insert(2);
        heap.insert(3);

        System.out.println("Tamaño del heap: " + heap.size());
        System.out.println("Máximo actual: " + heap.peek());

        System.out.println("\nExtrayendo elementos:");
        while (!heap.isEmpty()) {
            System.out.println(heap.extractMax());
        }

        System.out.println("¿Heap vacío después de extraer todo? " + heap.isEmpty());

        // HeapSort (prueba)
        System.out.println("\nProbando heapSort:");
        heap.insert(1);
        heap.insert(4);
        heap.insert(5);
        heap.insert(2);
        heap.insert(3);


        int[] listaOrdenada = Heap.heapSort(heap);
        System.out.println("Lista ordenada mediante HeapSort:");
        for (int num : listaOrdenada) {
            System.out.print(num + " ");
        }
    }
        
}