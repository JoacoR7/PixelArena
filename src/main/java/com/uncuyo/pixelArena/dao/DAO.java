package com.uncuyo.pixelArena.dao;

import java.util.List;

public interface DAO<T> {
    public void insertar(T entidad);
    public void modificar(T entidad);
    public void eliminar(T entidad);
    public T buscarPorId(long id);
    public List<T> listar();
}
