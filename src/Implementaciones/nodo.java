package Implementaciones;

public class nodo {
    int valor;
    nodo left;
    nodo right;
    nodo parent;

    public nodo(int valor) {
        this.valor = valor;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}