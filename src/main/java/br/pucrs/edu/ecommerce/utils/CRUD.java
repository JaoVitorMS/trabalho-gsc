package br.pucrs.edu.ecommerce.utils;

public interface CRUD<T>{
    void adicionar(T obj);
    void remover(T obj);
    void atualizar(T obj);
    T buscarPorId(Integer id);
}
