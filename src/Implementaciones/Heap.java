package Implementaciones;

import Interfaces.HeapsTDA;

public class Heap implements HeapsTDA {
    private nodo root;
    private int cantidad;

    public Heap() {
        this.root = null;
        this.cantidad = 0;
    }

    public void insert(int value) {
        nodo nuevo = new nodo(value);
        if (root == null) {
            root = nuevo;
        } else {
            insertarSimple(root, nuevo);
        }
        flotar(nuevo);
        cantidad++;
    }
    public int extractMax() {
        if (isEmpty()) {
            System.out.println("Heap vacío. No se puede extraer.");
            return -1;
        }
        int maximo = root.valor;
        if (cantidad == 1) {
            root = null;
        } else {
            nodo ultimo = buscarUltimo(root);
            if (ultimo != null) {
                root.valor = ultimo.valor;
                eliminarUltimo(root);
                hundir(root);
            }
        }
        cantidad--;
        return maximo;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Heap vacío. No se puede consultar.");
            return -1;
        }
        return root.valor;
    }

    public int size() {
        return cantidad;
    }

    public boolean isEmpty() {
        return cantidad == 0;
    }
// Heapsort
public static int[] heapSort(Heap heapOriginal) {
    int n = heapOriginal.size();
    int [] ordenado = new int[n];


    for (int i = (n-1); i >= 0; i--){
        ordenado[i] = heapOriginal.extractMax();
    }
    return ordenado;
}


    // ========== Métodos privados ==========

    private void flotar(nodo nodoActual) {
        while (nodoActual.parent != null && nodoActual.valor > nodoActual.parent.valor) {
            int aux = nodoActual.valor;
            nodoActual.valor = nodoActual.parent.valor;
            nodoActual.parent.valor = aux;
            nodoActual = nodoActual.parent;
        }
    }

    private void hundir(nodo nodoActual) {
        while (nodoActual.left != null) {
            nodo mayor = nodoActual.left;
            if (nodoActual.right != null && nodoActual.right.valor > nodoActual.left.valor) {
                mayor = nodoActual.right;
            }
            if (mayor.valor > nodoActual.valor) {
                int aux = nodoActual.valor;
                nodoActual.valor = mayor.valor;
                mayor.valor = aux;
                nodoActual = mayor;
            } else {
                break;
            }
        }
    }

    private void insertarSimple(nodo actual, nodo nuevo) {
        if (actual.left == null) {
            actual.left = nuevo;
            nuevo.parent = actual;
        } else if (actual.right == null) {
            actual.right = nuevo;
            nuevo.parent = actual;
        } else {
            if (contar(actual.left) <= contar(actual.right)) {
                insertarSimple(actual.left, nuevo);
            } else {
                insertarSimple(actual.right, nuevo);
            }
        }
    }

    private int contar(nodo nodoActual) {
        if (nodoActual == null) return 0;
        return 1 + contar(nodoActual.left) + contar(nodoActual.right);
    }

    private nodo buscarUltimo(nodo actual) {
        if (actual.left == null && actual.right == null) {
            return actual;
        }
        if (actual.right != null) {
            return buscarUltimo(actual.right);
        }
        if (actual.left != null) {
            return buscarUltimo(actual.left);
        }
        return null;
    }

    private void eliminarUltimo(nodo actual) {
        if (actual.right != null && actual.right.left == null && actual.right.right == null) {
            actual.right = null;
        } else if (actual.left != null && actual.left.left == null && actual.left.right == null) {
            actual.left = null;
        } else {
            if (actual.right != null) {
                eliminarUltimo(actual.right);
            } else if (actual.left != null) {
                eliminarUltimo(actual.left);
            }
        }
    }
}