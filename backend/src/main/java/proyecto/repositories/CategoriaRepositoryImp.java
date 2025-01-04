package proyecto.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import proyecto.models.CategoriaModel;

import java.util.List;

@Repository
public class CategoriaRepositoryImp implements CategoriaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public ResponseEntity<List<Object>> findAll() {
        try(Connection conn = sql2o.open()){
            List<CategoriaModel> categorias = conn.createQuery("SELECT * FROM categoria")
                    .executeAndFetch(CategoriaModel.class);
            List<Object> result = (List) categorias;
            if(categorias.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @Override
    public ResponseEntity<Object> findById(int id_categoria) {
        try(Connection conn = sql2o.open()){
            CategoriaModel categoria = conn.createQuery("SELECT * FROM categoria WHERE id_categoria = :id_categoria")
                    .addParameter("id_categoria", id_categoria)
                    .executeAndFetchFirst(CategoriaModel.class);
            if(categoria == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(categoria);
        } catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @Override
    public ResponseEntity<Object> create(CategoriaModel categoria) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO categoria (nombre) VALUES (:nombre)", true)
                    .addParameter("nombre", categoria.getNombre())
                    .executeUpdate();
            return ResponseEntity.ok(categoria);
        } catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @Override
    public ResponseEntity<Object> update(CategoriaModel categoria) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE categoria SET nombre = :nombre WHERE id_categoria = :id_categoria")
                    .addParameter("nombre", categoria.getNombre())
                    .addParameter("id_categoria", categoria.getId_categoria())
                    .executeUpdate();
            return ResponseEntity.ok(categoria);
        } catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @Override
    public ResponseEntity<Object> delete(int id_categoria) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM categoria WHERE id_categoria = :id_categoria")
                    .addParameter("id_categoria", id_categoria)
                    .executeUpdate();
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

}
