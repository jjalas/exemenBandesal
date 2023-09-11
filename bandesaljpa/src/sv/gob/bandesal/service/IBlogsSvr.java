package sv.gob.bandesal.service;

import java.util.List;

import sv.gob.bandesal.entidades.negocio.Blogs;

public interface IBlogsSvr {
   List<Blogs> findAll();
   void guardar(Blogs ob);
   void actualizar(Blogs ob);
   void eliminar(Blogs ob);
   
}
