package br.pucrs.edu.ecommerce.usuarios;

public interface Usuario<T> {
    void adicionar(T obj);
    void remover(T obj);
    void atualizar(T obj);
    T buscarPorId(int id);
}
